package org.dimigo.stack;

import java.util.Scanner;
import java.util.Stack;

// 역순 출력
public class Stack1_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        char[] arr = str.toCharArray();
        int size = arr.length;
        Stack stack = new Stack();

        for (int i = 0; i < size; i++) {
            stack.push(arr[i]);
        }

        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop());
        }
    }
}
