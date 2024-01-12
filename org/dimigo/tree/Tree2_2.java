package org.dimigo.tree;

/**
 * 주어진 트리가 이진 탐색 트리인지 확인하기
 *
 *  예) 3 입력시 true
 *     1
 *   0  2
 *
 *  예) 3 입력 후  root.left.left = 노드3일 경우 false
 *      1
 *    0  2
 *   3
 */
public class Tree2_2 {

    public static void main(String[] args) {
        BST bst = new BST(3);
        System.out.println(bst.isBST());        // true
        System.out.println(bst.isBST2());        // true

        bst.root.left.left = new TreeNode(3);
        bst.size++;
        System.out.println(bst.isBST());        // false
        System.out.println(bst.isBST2());        // false
    }
}
