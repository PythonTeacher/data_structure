package org.dimigo.stack;

import java.util.Scanner;
import java.util.Stack;

// 천단위 콤마
public class Stack2_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        char[] arr = str.toCharArray();
        int size = arr.length;
        Stack<Character> stack = new Stack();

        for (int i = size - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }

        while (!stack.isEmpty()) {
            int t = stack.size() % 3;
            if (t == 0) t = 3;
            for (int i = 0; i < t; i++) {
                System.out.print(stack.pop());
            }
            if(!stack.isEmpty()) System.out.print(",");
        }
    }
}
