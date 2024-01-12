package org.dimigo.list;

import java.util.LinkedList;
import java.util.Scanner;

// 어떤 숫자를 자릿수별로 한개씩 LinkedList에 담았다. (이 때 1의 자리가 Header에 오도록 거꾸로 담음)
// 이러한 LinkedList 2개를 받아서 합계를 계산하고, 같은 방식으로 LinkedList에 담아서 반환하기
public class List2_4 {

    private static long getNumber(LinkedList<Long> list) {
        int n = 1;
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += (n * list.get(i));
            n *= 10;
        }
        return sum;
    }

    private static void printResult(long n) {
        LinkedList<Long> list = new LinkedList<>();
        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        LinkedList<Long> a = new LinkedList<>();
        LinkedList<Long> b = new LinkedList<>();
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            a.add(s.nextLong());
        }

        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            b.add(s.nextLong());
        }

        long result = getNumber(a) + getNumber(b);
        printResult(result);
    }

}