package org.dimigo.stack;

import java.util.Scanner;
import java.util.Stack;

// 탑 신호
public class Stack3_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < n; i++) {
            stack.push(s.nextInt());
        }

        Stack<Integer> result = new Stack();
        boolean flag = false;
        while (!stack.isEmpty()) {
            int t = stack.pop();
            for (int i = stack.size() - 1; i >= 0; i--) {
                if (t < stack.get(i)) {
                    result.push(i + 1);
                    flag = true;
                    break;
                }
            }
            if (!flag) result.push(0);
            flag = false;
        }

        while (!result.isEmpty()) {
            System.out.print(result.pop() + " ");
        }
    }
}
