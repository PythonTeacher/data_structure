package org.dimigo.stack;

import java.util.Scanner;
import java.util.Stack;

// 제로
public class Stack1_4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < n; i++) {
            int t = s.nextInt();
            if (t == 0) stack.pop();
            else stack.push(t);
        }

        int sum = 0;
        while(!stack.empty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
