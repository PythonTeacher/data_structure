package org.dimigo.algo;

import java.math.BigInteger;
import java.util.Scanner;

// 분할 정복법 (거듭제곱) - Advanced
public class Algo1_1A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int b = s.nextInt();        // 밑수
        int n = s.nextInt();        // 지수

        System.out.println(pow(b, n));
    }

    // 분할 정복 알고리즘 적용
    private static BigInteger pow(int b, int n) {
        if (n == 0) return BigInteger.ONE;
        if (n == 1) return BigInteger.valueOf(b);
        if (n % 2 == 0) {
            BigInteger result = pow(b, n / 2);
            return result.multiply(result);
        } else {
            BigInteger result = pow(b, n / 2);
            return result.multiply(result).multiply(BigInteger.valueOf(b));
        }
    }
}
