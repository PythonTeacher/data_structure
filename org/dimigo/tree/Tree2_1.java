package org.dimigo.tree;

import java.util.Scanner;

/**
 * 이진탐색트리로 만들기
 *
 * 예) 10 입력 시
 *       (4)
 *     /     \
 *   (1)     (7)
 *   / \     / \
 * (0) (2) (5) (8)
 *       \   \   \
 *      (3)  (6) (9)
 */
class BST {
    TreeNode root;
    int size;
    int index;

    public BST(int size) {
        this.size = size;
        this.index = 0;
        root = makeBST(0, size - 1);
    }

    // 이진탐색트리 만들기
    public TreeNode makeBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(mid);

        node.left = makeBST(start, mid - 1);
        node.right = makeBST(mid + 1, end);
        return node;
    }

    // 이진탐색트리 탐색하기
    public void searchTree(int key) {
        searchTreeR(root, key);
    }

    public void searchTreeR(TreeNode n, int key) {
        if (key < n.data) {
            System.out.println("Data is smaller than " + n.data);
            searchTreeR(n.left, key);
        } else if (key > n.data) {
            System.out.println("Data is bigger than " + n.data);
            searchTreeR(n.right, key);
        } else {
            System.out.println("Data Found!");
        }
    }

    // 이진탐색트리가 맞는지 검증하기
    // 1. Array 사용하기
    boolean isBST() {
        int[] arr = new int[size];
        index = 0;
        inorder(root, arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }

    void inorder(TreeNode root, int[] arr) {
        if (root != null) {
            inorder(root.left, arr);
            arr[index++] = root.data;
            inorder(root.right, arr);
        }
    }

    // 2. min/max값 이용하기
    boolean isBST2() {
        return isBTS2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBTS2(TreeNode n, int min, int max) {
        if (n == null) return true;
        if (n.data < min || n.data > max) return false;
        if (!isBTS2(n.left, min, n.data) || !isBTS2(n.right, n.data, max)) {
            return false;
        }
        return true;
    }
}

public class Tree2_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        BST bst = new BST(n);
        bst.searchTree(3);
    }
}
