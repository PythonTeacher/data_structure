package org.dimigo.algo;

import java.util.Scanner;

public class Algo2_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();        // 동전 갯수
        int[] coin = new int[n];    // 동전 배열

        for (int i = 0; i < n; i++) {
            coin[i] = s.nextInt();
        }
        int money = s.nextInt();    // 거스름돈

        int[] c = new int[money + 1];       // 최소 동전의 수 배열
        for (int i = 1; i <= money; i++) {
            c[i] = -1;
            for (int j = 0; j < n; j++) {
                if (coin[j] <= i) {
                    int t = c[i - coin[j]];
                    if (t < 0) continue;
                    if (c[i] < 0 || t + 1 < c[i]) c[i] = t + 1;
                }
            }
        }

        if (c[money] == -1) System.out.println(0);
        else System.out.println(c[money]);
    }
}
