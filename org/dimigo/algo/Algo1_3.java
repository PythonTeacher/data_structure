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
public class Algo1_3 {

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

        int ans = solve();
        System.out.println(ans);

        money = 123;
        ans = solve2(money, 0, 0);
        System.out.println(ans);
    }

    private static int solve() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += money / coin[i];
            //money -= (change * coin[i]);
            money %= coin[i];
            if (money == 0) break;
        }
        return money == 0 ? ans : -1;
    }

    private static int solve2(int money, int i, int ans) {
        if (money == 0) return ans;  // 계산이 끝난 경우
        if (i == n && money > 0) {
            return -1;  // 모든 동전을 다 계산한 경우
        }
        ans += money / coin[i];
        return solve2(money % coin[i], i + 1, ans);
    }
}
