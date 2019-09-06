package com.clownfish7.tree.threadedbinarytree;

/**
 * @author yzy
 * @classname ThreadedBinaryTreeDemo
 * @description 线索化二叉树
 * @create 2019-09-06 11:20
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        HeroNode node1 = new HeroNode(1, "1");
        HeroNode node3 = new HeroNode(3, "3");
        HeroNode node6 = new HeroNode(6, "6");
        HeroNode node8 = new HeroNode(8, "8");
        HeroNode node10 = new HeroNode(10, "10");
        HeroNode node14 = new HeroNode(14, "14");

        tree.setRoot(node1);
        node1.setLeft(node3);
        node1.setRight(node6);
        node3.setLeft(node8);
        node3.setRight(node10);
        node6.setLeft(node14);

        tree.threadedNodesPost();
        System.out.println(node3.getLeft());
        System.out.println(node3.getRight());

        System.out.println("---------------");
//        tree.threadedList();
    }
}
