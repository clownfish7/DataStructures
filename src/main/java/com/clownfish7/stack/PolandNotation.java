package com.clownfish7.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author You
 * @create 2019-08-31 17:48
 */
public class PolandNotation {
    public static void main(String[] args) {

        // 1+((2+3)*4)-5  ->  1 2 3 + 4 * + 5 -
        String infixExpression = "1+((2+3)*4)-5";
        List<String> list = toInffixExpression(infixExpression);
        System.out.println(list);

        List<String> list1 = infix2SuffixExpressionList(list);
        System.out.println(list1);

        System.out.println("1+((2+3)*4)-5  ->  1 2 3 + 4 * + 5 - -> "+calcute(list1));


        // (3+4)x5-6  ->  3 4 + 5 x 6 -
//        String suffixExpression = "3 4 + 5 * 6 - ";
//        List<String> listString = getListString(suffixExpression);
//        System.out.println(listString);
//
//        int res = calcute(listString);
//        System.out.println("(3+4)x5-6 = " + res);
    }

    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    public static int calcute(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (s.equals("+")) {
                    res = num1 + num2;
                } else if (s.equals("-")) {
                    res = num1 - num2;
                } else if (s.equals("*")) {
                    res = num1 * num2;
                } else if (s.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static List<String> toInffixExpression(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;
        String str;
        char c;

        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while (i < s.length());
        return list;
    }

    public static List<String> infix2SuffixExpressionList(List<String> list) {
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        for (String s : list) {
            if (s.matches("\\d+")) {
                s2.add(s);
            } else if (s.equals("(")) {
                s1.push(s);
            } else if (s.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(s)) {
                    s2.add(s1.pop());
                }
                s1.push(s);
            }
        }

        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int res = 0;
        switch (operation) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println("not exist");
                break;
        }
        return res;
    }
}