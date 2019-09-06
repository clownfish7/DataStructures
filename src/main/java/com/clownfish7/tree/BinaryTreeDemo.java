package com.clownfish7.tree;

/**
 * @author yzy
 * @classname BinaryTreeDemo
 * @description 二叉树
 * @create 2019-09-05 16:31
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        tree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        System.out.println("===== preOrder =====  12354");
        tree.preOrder();
        System.out.println("===== infixOrder =====  21534");
        tree.infixOrder();
        System.out.println("===== postOrder =====  25431");
        tree.postOrder();

        System.out.println("=============================");
        System.out.println(tree.preFind(2));
        System.out.println(tree.infixFind(4));
        System.out.println(tree.postFind(5));

        System.out.println("=============================");
        tree.preOrder();
        tree.delete(3);
        System.out.println("after");
        tree.preOrder();

    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("the binary tree is null !");
        }
    }

    public HeroNode preFind(int id) {
        return this.root.preFind(id);
    }

    // 中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("the binary tree is null !");
        }
    }

    public HeroNode infixFind(int id) {
        return this.root.infixFind(id);
    }

    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("the binary tree is null !");
        }
    }

    public HeroNode postFind(int id) {
        return this.root.postFind(id);
    }

    // 删除
    public void delete(int id) {
        if (this.root == null) {
            System.out.println("root is null !");
            return;
        }
        if (this.root.getId() == id) {
            this.root = null;
            System.out.println("ok");
            return;
        }
        this.root.delete(id);
    }

}

class HeroNode {
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;

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

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public HeroNode preFind(int id) {
        if (this.id == id) {
            return this;
        }
        if (this.left != null) {
            HeroNode node = this.left.preFind(id);
            if (node != null) {
                return node;
            }
        }
        if (this.right != null) {
            return this.right.preFind(id);
        }
        return null;
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public HeroNode infixFind(int id) {

        if (this.left != null) {
            HeroNode node = this.left.infixFind(id);
            if (node != null) {
                return node;
            }
        }
        if (this.id == id) {
            return this;
        }
        if (this.right != null) {
            return this.right.infixFind(id);
        }
        return null;
    }

    // 后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode postFind(int id) {
        if (this.left != null) {
            HeroNode node = this.left.postFind(id);
            if (node != null) {
                return node;
            }
        }
        if (this.right != null) {
            HeroNode node = this.right.postFind(id);
            if (node != null) {
                return node;
            }
        }
        System.out.println("post");
        if (this.id == id) {
            return this;
        }
        return null;
    }

    // 删除
    public void delete(int id) {
        if (this.left != null) {
            if (this.left.id == id) {
                if (this.left.left == null && this.left.right == null) {
                    this.left = null;
                } else if (this.left.left != null) {
                    this.left.left.right = this.left.right;
                    this.left = this.left.left;
                }
            } else {
                this.left.delete(id);
            }
        }

        if (this.right != null) {
            if (this.right.id == id) {
                if (this.right.left == null && this.right.right == null) {
                    this.right = null;
                } else if (this.right.left != null) {
                    this.right.left.right = this.right.right;
                    this.right = this.right.left;
                }
            } else {
                this.right.delete(id);
            }
        }
    }
}
