package com.clownfish7.tree.threadedbinarytree;

/**
 * @author yzy
 * @classname BinaryTree
 * @description TODO
 * @create 2019-09-06 11:27
 */
class BinaryTree {
    private HeroNode root;
    private HeroNode pre;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes() {
        threadedNodes(root);
    }

    public void threadedNodesPre() {
        threadedNodesPre(root);
    }

    public void threadedNodesPost() {
        threadedNodesPost(root);
    }

    // 前序线索化
    public void threadedNodesPre(HeroNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        threadedNodesPost(node.getLeft());
        threadedNodesPost(node.getRight());
    }

    // 中序线索化
    public void threadedNodes(HeroNode node) {
        if (node == null) {
            return;
        }
        threadedNodes(node.getLeft());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        threadedNodes(node.getRight());
    }

    // 后序线索化
    public void threadedNodesPost(HeroNode node) {
        if (node == null) {
            return;
        }
        threadedNodesPost(node.getLeft());
        threadedNodesPost(node.getRight());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
    }

    // 遍历中序线索化
    public void threadedList() {
        HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType()==1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }



}
