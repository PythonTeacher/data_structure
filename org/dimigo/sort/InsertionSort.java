package org.dimigo.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
    private static void insertionSort(int[] a) {
        int j, key;
        for (int i = 1; i < a.length; i++){
            key = a[i];     // 삽입될 숫자
            for (j = i - 1; j >= 0 && a[j] > key; j--) {
                a[j + 1] = a[j];    // key값보다 배열에 있는 값이 크면 j번째를 j+1번째로 이동
            }
            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Random().nextInt(100);
        }
        System.out.println("< Sort 전 >");
        System.out.println(Arrays.toString(a));
        insertionSort(a);
        System.out.println("< Sort 후 >");
        System.out.println(Arrays.toString(a));
    }
}
