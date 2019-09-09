package com.clownfish7.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yzy
 * @classname HuffmanTree
 * @description 赫夫曼树
 * @create 2019-09-09 9:41
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        root.preOrder(root);
        root.preOrder();
    }

    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            System.out.println("nodes = " + nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public void preOrder(Node root) {
        if (root == null) {
            System.out.println("the root node is null!");
        }
        System.out.println(root.value);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left!=null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
