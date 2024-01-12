package org.dimigo.algo;

import java.math.BigInteger;
import java.util.Scanner;

// 분할 정복법 (거듭제곱) - Large
public class Algo1_1L {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int b = s.nextInt();        // 밑수
        int n = s.nextInt();        // 지수

        System.out.println(pow(b, n));
        System.out.println(pow2(b, n));
    }

    // 반복문
    private static BigInteger pow(int b, int n) {
        BigInteger result = BigInteger.ONE;        // long의 경우 2^62까지 계산 가능
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(b));
        }
        return result;
    }

    // 재귀호출
    private static BigInteger pow2(int b, int n) {
        if (n == 0) return BigInteger.ONE;
        if (n == 1) return BigInteger.valueOf(b);
        return BigInteger.valueOf(b).multiply(pow2(b, n - 1));
    }

}
