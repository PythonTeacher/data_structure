package org.dimigo.array;

import java.util.Scanner;

// 괄호 갯수 출력하기 (난이도:중)
public class Array2_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        char[] arr = str.toCharArray();
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ')' && arr[i-1] == '(') {
                cnt++;
                for (int j = i + 1; j < arr.length; j++) {
                    arr[j-2] = arr[j];
                }
                arr[arr.length-1] = ' ';
                arr[arr.length-2] = ' ';
                i -= 2;
            }
        }
        System.out.println(cnt);
    }
}
