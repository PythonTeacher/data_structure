package org.dimigo.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
    private static void selectionSort(int[] a) {
        int min, temp;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
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
        selectionSort(a);
        System.out.println("< Sort 후 >");
        System.out.println(Arrays.toString(a));
    }
}
