package org.dimigo.algo;

import java.math.BigInteger;
import java.util.Scanner;

// 동적 계획법 (피보나치 수열) - Large
public class Algo1_2L {
    private static BigInteger[] dp;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        dp = new BigInteger[n + 1];

        long start = System.nanoTime();
        System.out.println(fibo(n));
        long end = System.nanoTime();
        System.out.println("fibo:" + (end - start));
        System.out.println(Long.MAX_VALUE);
    }

    // 재귀문 + 동적계획법 (하향식) - 메모이제이션
    private static BigInteger fibo(int n) {
        if(n <= 1) return BigInteger.valueOf(n);
        if (dp[n] != null) return dp[n];
        return dp[n] = fibo(n - 1).add(fibo(n - 2));
    }

}
