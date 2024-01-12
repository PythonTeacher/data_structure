package org.dimigo.array;

import java.util.Scanner;

// 홀수 마방진 (난이도:중)
/*
1. 시작은 첫 행 , 중간 열 에서 1 을 두고
2. 행을 감소, 열을 증가하면서 순차적으로 수를 넣어간다.
3. 행은 감소하므로 행이 첫 행보다 작아지는 경우는 행은 마지막 행으로 넘어간다.
4. 열은 증가하므로 열이 끝 열을 넘어가는 경우 열은 첫 열로 넘어간다.
5. 테이블에 들어간 수가 n 의 배수이면 행만 증가(열은 변화없음)
 */
public class Array2_4 {
    private static int n;

    public static void makeMatrix(int[][] arr) {
        int num = 1;
        // 현재 행, 열 정보
        int row = 0, col = n/2;
        int lastNum = n * n;

        // 1은 첫째 행, 가운데 열에 넣기
        arr[row][col] = num;

        // 행을 감소, 열을 증가시켜가며 숫자 넣기
        while (num < lastNum) {
            if (num % n != 0) {
                row = (row + (n - 1)) % n;
                col = (col + 1) % n;
            } else {
                // 숫자가 n의 배수이면 행만 증가
                row = (row + 1) % n;
            }
            arr[row][col] = ++num;
        }
    }

    public static void printMatrix(int[][] arr) {
        for (int[] a : arr) {
            for (int v : a) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int[][] arr = new int[n][n];

        makeMatrix(arr);
        printMatrix(arr);
    }
}
