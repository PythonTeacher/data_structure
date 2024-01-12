package org.dimigo.algo;

import java.math.BigInteger;
import java.util.Scanner;

// 동적 계획법 (피보나치 수열) - Advanced
public class Algo1_2A {
    private static BigInteger[] dp;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        dp = new BigInteger[n + 1];

        long start = System.nanoTime();
        System.out.println(fibo(n));
        long end = System.nanoTime();
        System.out.println("fibo:" + (end - start));

        start = System.nanoTime();
        System.out.println(fibo2(n));
        end = System.nanoTime();
        System.out.println("fibo2:" + (end - start));
    }

    // 반복문 + 동적 계획법 (상향식)
    private static BigInteger fibo(int n) {
        if(n <= 1) return BigInteger.valueOf(n);
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            //dp[i] = dp[i-1] + dp[i-2];
            dp[i] = dp[i-1].add(dp[i-2]);
        }
        return dp[n];
    }

    private static BigInteger fibo2(int n) {
        if(n <= 1) return BigInteger.valueOf(n);
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ZERO;
        for (int i = 2; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }
}
