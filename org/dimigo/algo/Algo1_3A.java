package org.dimigo.algo;

import java.util.Scanner;

/*
 그리디 : 거스름돈
 나라마다 통용되는 동전의 종류가 다르다. 그 나라에서 이용하는 동전의 가지수와 동전의 종류를 입력받고
 거슬러 주어야 할 돈이 입력되었을 때 여러 가지 방법들 중 가장 적은 동전의 수를 구하는 프로그램을 작성하시오.

 1) 첫번째 줄에는 그 나라에서 사용되는 동전의 종류의 수 N이 입력된다. (1 <= N <= 10)
 2) 두번째 줄에는 동전의 수만큼 동전 액수가 내림차순으로 입력된다. (10 <= 액수 <= 10,000)
 3) 마지막 줄에는 거슬러주어야 할 돈의 액수 M이 입력된다. (10 <= M <= 10,000)
 */
public class Algo1_3A {
    static int ans = Integer.MAX_VALUE;
    static int n;
    static int[] coin;
    static int money;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();        // 동전 갯수
        coin = new int[n];    // 동전 배열

        for (int i = 0; i < n; i++) {
            coin[i] = s.nextInt();
        }
        money = s.nextInt();    // 거스름돈

        solve(0, 0);
        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    // cnt : 현재까지 사용한 동전의 수
    // ans : 지금까지 최소 동전의 수
    private static void solve(int m, int cnt) {
        //System.out.printf("m:%d, cnt:%d\n", m, cnt);
        if (cnt > ans) return;
        if (m > money) return;
        if (m == money) {
            if (cnt < ans) ans = cnt;

            return;
        }
        for (int i = 0; i < n; i++) {
            solve(m + coin[i], cnt + 1);
        }
    }
}
