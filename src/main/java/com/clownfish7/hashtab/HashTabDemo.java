package com.clownfish7.hashtab;

import java.util.Scanner;

/**
 * @author yzy
 * @classname HashTabDemo
 * @description TODO
 * @create 2019-09-04 17:33
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(10);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("id:");
            int id = scanner.nextInt();
            System.out.println("name:");
            String name = scanner.next();
            hashTab.add(new Emp(id, name));
            System.out.println("go on?");
            String tag = scanner.next();
            if ("n".equals(tag)) {
                break;
            } else if ("find".equals(tag)) {
                System.out.println("findById:");
                int empId = scanner.nextInt();
                System.out.println("findById: -> " + hashTab.findById(empId));
            }
        }
        hashTab.list();
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = emp;
    }

    public void list() {
        if (head == null) {
            System.out.println("当前链表为空！");
            return;
        }
        Emp current = head;
        while (current != null) {
            System.out.printf("=> id=%d, name=%s ", current.id, current.name);
            current = current.next;
        }
        System.out.println();
    }

    public Emp findById(int id) {
        Emp current = head;
        while (current != null) {
            if (current.id == id) {
                return current;
            }
            current = current.next;
        }
        System.out.println("canot find ,!");
        return null;
    }
}

class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < empLinkedListArray.length; i++) {
              empLinkedListArray[i] = new EmpLinkedList();

        }
    }

    public void add(Emp emp) {
        empLinkedListArray[hashFun(emp.id)].add(emp);
    }

    public void list() {
        for (int i = 0; i < empLinkedListArray.length; i++) {
            empLinkedListArray[i].list();
        }
    }

    private int hashFun(int id) {
        return id % size;
    }

    public Emp findById(int id) {
        return empLinkedListArray[hashFun(id)].findById(id);
    }
}
