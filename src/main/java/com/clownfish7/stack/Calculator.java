package com.clownfish7.stack;

/**
 * @author You
 * @create 2019-08-25 21:32
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "70+2*6-4";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        for (int i = 0; i < expression.length(); i++) {
            ch = expression.charAt(i);
            if (numStack.isOper(ch)) {
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    int pop = operStack.pop();
                    if (operStack.priority(pop) <= operStack.priority(ch)) {
                        operStack.push(pop);
                        operStack.push(ch);
                    } else {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = pop;
                        res = operStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }
                }
            } else {
                keepNum = keepNum + ch;
                if (i == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if (numStack.isOper(expression.charAt(i + 1))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
        }

        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = operStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println(expression + "=" + res);
    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is null");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("stack is null");
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
