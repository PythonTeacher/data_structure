package org.dimigo.tree;

public class TreeNode {
    public TreeNode left;
    public int data;
    public TreeNode right;

    public TreeNode(int data) {
        left = right = null;
        this.data = data;
    }
}
