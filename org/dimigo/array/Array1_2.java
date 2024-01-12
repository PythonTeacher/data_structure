package org.dimigo.array;

import java.util.Scanner;

// 문자열 역순 출력하기 (난이도:하)
public class Array1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. 문자열 입력
        String s = scanner.nextLine();
//        char[] arr = s.toCharArray();
//
//        // 2. 역순 출력
//        for(int i=arr.length-1; i>=0; i--) {
//            System.out.print(arr[i]);
//        }

        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
    }
}
