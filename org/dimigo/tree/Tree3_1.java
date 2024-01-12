package org.dimigo.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 이진 탐색 트리를 만들 수 있는 모든 순열의 경우의 수를 찾기
 */
public class Tree3_1 {

    static ArrayList allSequences(TreeNode node) {
        ArrayList<LinkedList> result = new ArrayList();
        if (node == null) {
            result.add(new LinkedList());
            return result;
        }
        LinkedList prefix = new LinkedList();
        prefix.add(node.data);

        ArrayList<LinkedList> leftSeq = allSequences(node.left);
        ArrayList<LinkedList> rightSeq = allSequences(node.right);

        for (LinkedList left : leftSeq) {
            for (LinkedList right : rightSeq) {
                ArrayList<LinkedList> weaved = new ArrayList();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                           ArrayList<LinkedList> results, LinkedList<Integer> prefix) {
        if (first.size() == 0 || second.size() == 0) {
            LinkedList result = new LinkedList();
            for (int data : prefix) result.add(data);
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    public static void main(String[] args) {
        BST bst = new BST(5);
        ArrayList<LinkedList> result = allSequences(bst.root);
        for (LinkedList<Integer> l : result) {
            for (int data : l) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }
}
