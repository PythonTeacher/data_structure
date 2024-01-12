package org.dimigo.stack;

import java.util.Scanner;

// 문자열 폭발
// https://www.acmicpc.net/problem/9935
public class Stack1_5 {
    // String 메소드로 풀기
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        //System.out.println(s);
        //System.out.println(t);

        while (s.contains(t)) {
            s = s.replace(t, "");
        }

        if (s.length() == 0) System.out.println("NONE");
        else System.out.println(s);
    }
}
