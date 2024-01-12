package org.dimigo.algo;

import java.util.Scanner;

// 분할 정복법 (거듭제곱) - Small
public class Algo1_1S {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int b = s.nextInt();        // 밑수
        int n = s.nextInt();        // 지수

        System.out.println(pow(b, n));
        System.out.println(pow2(b, n));
        System.out.println(Long.MAX_VALUE);
    }

    // 반복문
    private static int pow(int b, int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= b;
        }
        return result;
    }

    // 재귀호출
    private static int pow2(int b, int n) {
        if (n == 0) return 1;       // 2^0의 경우가 있으므로
        if (n == 1) return b;
        return b * pow2(b,n - 1);
    }

}
