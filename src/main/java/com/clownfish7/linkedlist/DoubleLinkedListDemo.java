package com.clownfish7.linkedlist;

/**
 * @author You
 * @create 2019-08-25 16:58
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        HeroNode2 node1 = new HeroNode2(1, "松江", "及时雨");
        HeroNode2 node2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 node3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 node4 = new HeroNode2(4, "林冲", "豹子头");

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
//
//        linkedList.add(node1);
//        linkedList.add(node4);
//        linkedList.add(node4);
//        linkedList.add(node3);
//        linkedList.add(node2);

//        System.out.println("get last index:");
//        HeroNode node = getLastIndex(linkedList.getHead(), 1);
//        System.out.println(node);
//
//        System.out.println("===== reserve =====");
//        reverseList(linkedList.getHead());
//        linkedList.list();
//
//        System.out.println("===== print reverse =====");
//        printReverse(linkedList.getHead());
    }
}


class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.no > heroNode.no) {
                temp.pre.next = heroNode;
                heroNode.pre = temp.pre;
                heroNode.next = temp;
                temp.pre = heroNode;
                return;
            }
            if (temp.no == heroNode.no) {
                System.out.println("已存在");
                return;
            }
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void list() {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }

    public void delete(int no) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            if (temp.next.no == no) {
                if (temp.next.next != null) {
                    temp.next.pre = temp;
                }
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 pre;
    public HeroNode2 next;

    public HeroNode2(int no, String name, String nickname) {
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
