package org.dimigo.array;

import java.util.Scanner;

// 숫자 로테이션 출력하기 (난이도:중)
public class Array2_1 {
    static void printReverse(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            for (int j=0; j<i; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = s.nextInt();
        }
        printReverse(arr);
    }
}
