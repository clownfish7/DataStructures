package com.clownfish7.tree.threadedbinarytree;

/**
 * @author yzy
 * @classname HeroNode
 * @description TODO
 * @create 2019-09-06 11:23
 */
class HeroNode {
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;
    // 0:左子树 1:前驱节点
    private int rightType;
    // 0:右子树 1:后继节点
    private int leftType;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
