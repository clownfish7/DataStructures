package com.clownfish7.linkedlist;

/**
 * @author You
 * @create 2019-08-25 18:30
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.addBoys(5);
        linkedList.showBoy();
        linkedList.countBoy(5, 1, 2);
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    public void addBoys(int nums) {
        if (nums < 2) {
            System.out.println("nums is not access");
            return;
        }
        Boy point = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                point = first;
                point.setNext(first);
            } else {
                boy.setNext(first);
                point.setNext(boy);
                point = boy;
            }
        }
    }

    public void showBoy() {
        if (first != null) {
            Boy point = first;
            System.out.println(point);
            while (point.getNext() != first) {
                point = point.getNext();
                System.out.println(point);
            }
        }
    }

    public void countBoy(int num, int start, int count) {
        Boy helper = first;
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }

        for (int i = 0; i < start - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true) {
            if (first == helper) {
                System.out.println("最后一个是: "+first.getNo());
                break;
            }
            for (int i = 0; i < count - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("出圈的是: "+first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}