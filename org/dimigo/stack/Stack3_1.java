package org.dimigo.stack;

import java.util.Scanner;
import java.util.Stack;

// 헤어스타일
public class Stack3_1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        Stack<Integer> stack = new Stack();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }

        int cnt = 0;
        while (!stack.isEmpty()) {
            int t = stack.pop();
            int size = stack.size();
            for (int i = size - 1; i >= 0; i--) {
                if (t > stack.get(i)) cnt++;
                else break;
            }
        }

        System.out.println(cnt);
    }
}
