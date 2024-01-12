package org.dimigo.stack;

import java.util.Scanner;
import java.util.Stack;

// 올바른 괄호
public class Stack2_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        char[] arr = str.toCharArray();
        int size = arr.length;

        Stack<Character> stack = new Stack();

        for (int i = 0; i < size; i++) {
            if (arr[i] == '(') stack.push(arr[i]);
            else if (arr[i] == ')') {
                if (stack.isEmpty()) {
                    System.out.println("bad");
                    return;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) System.out.println("good");
        else System.out.println("bad");
    }
}
