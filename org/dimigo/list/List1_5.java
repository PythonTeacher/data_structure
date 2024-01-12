package org.dimigo.list;

import java.util.LinkedList;
import java.util.Scanner;

// 연결리스트를 이용하여 특정 값을 기준으로 나누기
public class List1_5 {
    static LinkedList<Integer>[] split(LinkedList<Integer> list, int k) {
        LinkedList<Integer>[] arr = new LinkedList[2];
        arr[0] = new LinkedList<>();
        arr[1] = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < k) {
                arr[0].add(list.get(i));
            } else {
                arr[1].add(list.get(i));
            }
        }

        return arr;
    }

    static void printAll(LinkedList<Integer>[] arr) {
        for (int i = 0; i < arr[0].size(); i++) {
            System.out.print(arr[0].get(i) + " ");
        }
        for (int i = 0; i < arr[1].size(); i++) {
            System.out.print(arr[1].get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(s.nextInt());
        }

        LinkedList<Integer>[] arr = split(list, k);
        printAll(arr);
    }
}
