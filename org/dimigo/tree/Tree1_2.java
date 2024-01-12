package org.dimigo.tree;

/**
 *        (4)
 *      /    \
 *    (2)    (6)
 *   /  \   /  \
 * (1) (3) (5) (7)
 */
public class Tree1_2 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        /*TreeNode n1 = bst.makeNode(null, 1, null);
        TreeNode n3 = bst.makeNode(null, 3, null);
        TreeNode n5 = bst.makeNode(null, 5, null);
        TreeNode n7 = bst.makeNode(null, 7, null);
        TreeNode n2 = bst.makeNode(n1, 2, n3);
        TreeNode n6 = bst.makeNode(n5, 6, n7);
        TreeNode root = bst.makeNode(n2, 4, n6);
        bst.setRoot(root);
        bst.inorder();    // 1 2 3 4 5 6 7

        // 노드 탐색
        bst.searchBST(0);
        bst.searchBST(1);
        bst.searchBST(5);
        */
        // 노드 추가
        bst.insertBST(4);
        bst.insertBST(2);
        bst.insertBST(6);
        bst.insertBST(1);
        bst.insertBST(3);
        bst.insertBST(5);
        bst.insertBST(7);
        bst.insertBST(7);       // 7 Exists

        System.out.println(bst.size);

        bst.inorder();    // 1 2 3 4 5 6 7

        // 노드 탐색
        bst.searchBST(0);   // 0 Not Found
        bst.searchBST(1);   // 1 Found
        bst.searchBST(5);   // 5 Found

        // 1. 단말 노드 삭제
        bst.deleteBST(3);
        bst.inorder();          // 1 2 4 5 6 7

        // 2. 자식노드가 1개인 노드 삭제
        bst.deleteBST(2);
        bst.inorder();          // 1 4 5 6 7

        // 3. 자식노드가 2개인 노드 삭제
        bst.deleteBST(6);
        bst.inorder();          // 1 4 5 7

        // 4. 루트 삭제
        bst.deleteBST(4);
        bst.inorder();

        bst.deleteBST(5);
        bst.inorder();

        bst.deleteBST(7);
        bst.inorder();
    }
}
