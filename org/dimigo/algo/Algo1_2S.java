package org.dimigo.algo;

import java.util.Scanner;

// 동적 계획법 (피보나치 수열) - Small
public class Algo1_2S {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fibo(n));
    }

    // 일반 재귀 호출 (40부터 오래 걸림)
    private static int fibo(int n) {
        if(n <= 1) return n;
        return fibo(n - 1) +  fibo(n - 2);
    }

}
