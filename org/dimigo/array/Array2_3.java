package org.dimigo.array;

import java.util.Scanner;

// 격자판 출력 (난이도:중)
public class Array2_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i][0] = s.nextInt();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = arr[i][j-1] - arr[i-1][j-1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
