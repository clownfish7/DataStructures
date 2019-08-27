package com.clownfish7.queue;

import java.util.Scanner;

/**
 * @author You
 * @create 2019-08-24 20:02
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(git): 从队列取出数据");
            System.out.println("h(head): 产看队列头的数据");
            key = (char) scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    System.exit(0);
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    System.out.println("取出的数是: " + queue.getQueue());
                    break;
                case 'h':
                    System.out.println("队列头的数据是: " + queue.headQueue());
                    break;
                default:
                    System.out.println("reinput");
                    break;
            }
        }
    }
}

class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("队列满了~");
            return;
        }
        this.arr[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空~");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
