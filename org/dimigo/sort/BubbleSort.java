package org.dimigo.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    private static void bubbleSort(int[] a) {
        int temp = 0;
        for(int i = 0; i < a.length; i++) {
            for(int j = 1 ; j < a.length - i; j++) {
                if(a[j] < a[j-1]) {
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
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
        bubbleSort(a);
        System.out.println("< Sort 후 >");
        System.out.println(Arrays.toString(a));
    }
}
