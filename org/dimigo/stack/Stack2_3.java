package org.dimigo.stack;

import java.util.Scanner;
import java.util.Stack;

// 큰수 덧셈
public class Stack2_3 {
    static Stack<Integer> makeStack(char[] arr) {
        Stack<Integer> s = new Stack();
        for (int i = 0; i < arr.length; i++) {
            s.push(Integer.parseInt(arr[i]+""));
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String b = s.nextLine();

        Stack<Integer> s1 = makeStack(a.toCharArray());
        Stack<Integer> s2 = makeStack(b.toCharArray());
        Stack<Integer> result = new Stack();
        int u = 0;

        while (!s1.isEmpty() && !s2.isEmpty()) {
            int n1 = s1.pop();
            int n2 = s2.pop();
            int t = n1 + n2 + u;
            if (t > 9) {
                result.push(t % 10);
                u = 1;
            } else {
                result.push(t);
                u = 0;
            }
        }

        while (!s1.isEmpty()) {
            result.push(s1.pop() + u);
            u = 0;
        }
        while (!s2.isEmpty()) {
            result.push(s2.pop() + u);
            u = 0;
        }

        while (!result.isEmpty()) {
            System.out.print(result.pop());
        }
    }
}
