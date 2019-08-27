package com.clownfish7.linkedlist;

import java.util.Stack;

/**
 * @author You
 * @create 2019-08-24 21:46
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1, "松江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");

        linkedList.add(node1);
        linkedList.add(node4);
        linkedList.add(node4);
        linkedList.add(node3);
        linkedList.add(node2);

        linkedList.list();

        System.out.println("=====after delete=====");
        linkedList.delete(4);
        linkedList.delete(3);
        linkedList.delete(2);
        linkedList.delete(1);
        linkedList.list();

        linkedList.add(node1);
        linkedList.add(node4);
        linkedList.add(node4);
        linkedList.add(node3);
        linkedList.add(node2);

        System.out.println("get last index:");
        HeroNode node = getLastIndex(linkedList.getHead(), 1);
        System.out.println(node);

        System.out.println("===== reserve =====");
        reverseList(linkedList.getHead());
        linkedList.list();

        System.out.println("===== print reverse =====");
        printReverse(linkedList.getHead());
    }

    public static HeroNode getLastIndex(HeroNode head, int index) {
        HeroNode heroNode = head;
        HeroNode node = null;
        int count = 0;
        while (heroNode.next != null) {
            heroNode = heroNode.next;
            count++;
            if (count == index) {
                node = head.next;
            }
            if (count > index) {
                node = node.next;
            }
        }
        return node;
    }

    public static void reverseList(HeroNode head) {
        HeroNode reverse = new HeroNode(0, "", "");
        HeroNode cur = head.next;
        HeroNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = reverse.next;
            reverse.next = cur;
            cur = next;
        }
        head.next = reverse.next;
    }

    public static void printReverse(HeroNode head) {
        Stack<HeroNode> stack = new Stack<>();
        while (head.next != null) {
            head = head.next;
            stack.push(head);
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}

class SingleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            HeroNode before = temp;
            temp = temp.next;
            if (temp.no > heroNode.no) {
                heroNode.next = temp;
                before.next = heroNode;
                return;
            }
            if (temp.no == heroNode.no) {
                System.out.println("已存在");
                return;
            }
        }
        temp.next = heroNode;
    }

    public void list() {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }

    public void delete(int no) {
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
