package org.dimigo.tree;

/**
 *        (1)
 *       /  \
 *     (2)  (3)
 *    /  \
 *  (4)   (5)
 */
public class Tree1_1 {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode n4 = bt.makeNode(null, 4, null);
        TreeNode n5 = bt.makeNode(null, 5, null);
        TreeNode n2 = bt.makeNode(n4, 2, n5);
        TreeNode n3 = bt.makeNode(null, 3, null);
        TreeNode n1 = bt.makeNode(n2, 1, n3);

        bt.setRoot(n1);
        System.out.println(bt.size);

        bt.preorder(n1);
        System.out.println();   // 1 2 4 5 3

        bt.inorder(n1);
        System.out.println();   // 4 2 5 1 3

        bt.postorder(n1);
        System.out.println();   // 4 5 2 3 1

        bt.levelorder();
        System.out.println();   // 1 2 3 4 5
    }

    public static void main2(String[] args) {
        // top-down 방식
        TreeNode root = new TreeNode(1);
        BinaryTree bt = new BinaryTree();
        bt.setRoot(root);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        bt.setLeftNode(root, node2);
        bt.setRightNode(root, node3);

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        bt.setLeftNode(node2, node4);
        bt.setRightNode(node2, node5);

        //bt.printTree(root);             // 1 2 4 5 3
        System.out.println();
        System.out.println(bt.size);    // 5
    }
}
