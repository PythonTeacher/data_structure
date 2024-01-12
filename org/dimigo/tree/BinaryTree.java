package org.dimigo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public TreeNode root;
    public int size;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode makeNode(TreeNode left, int data, TreeNode right) {
        TreeNode node = new TreeNode(data);
        node.left = left;
        node.right = right;
        size++;
        return node;
    }

    public void setLeftNode(TreeNode parent, TreeNode child) {
        parent.left = child;
        size++;
    }

    public void setRightNode(TreeNode parent, TreeNode child) {
        parent.right = child;
        size++;
    }

    public void preorder(TreeNode node){
        if(node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void postorder(TreeNode node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public void levelorder() {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null) queue.offer(temp.left);
            if(temp.right != null) queue.offer(temp.right);
        }
    }
}
