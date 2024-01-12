package org.dimigo.stack;

import java.util.Scanner;
import java.util.Stack;

// 쇠막대기
public class Stack3_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().trim();
        int size = str.length();
        Stack<Character> stack = new Stack();
        int cnt = 0;

        for (int i = 0; i < size; i++) {
            char c = str.charAt(i);
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (str.charAt(i - 1) == '(') { // 레이저인 경우
                    stack.pop();
                    cnt += stack.size();
                } else {        // 쇠막대기인 경우
                    stack.pop();
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
