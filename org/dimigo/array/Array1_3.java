package org.dimigo.array;

import java.util.Scanner;

// 빠진 카드 숫자 찾기 (난이도:하)
public class Array1_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n+1];

        for (int i = 1; i < n; i++) {
            int t = s.nextInt();
            arr[t] = 1;
        }
        //System.out.println(Arrays.toString(arr));

        for (int i = 1; i < n + 1; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
                return;
            }
        }
    }
}
