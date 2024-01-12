package org.dimigo.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    private static void quick_sort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = partition(arr, low, high);
        quick_sort(arr, low, mid - 1);
        quick_sort(arr, mid, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        while (low <= high) {
            while (arr[low] < pivot) low++;
            while (arr[high] > pivot) high--;
            if (low <= high) {
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
                low++;
                high--;
            }
        }
        return low;
    }

    private static void quickSort(int[] arr, int left, int right) {
        int low = left;
        int high = right;
        if (low >= high) return;
        int pivot = arr[(low + high) / 2];
        while (low <= high) {
            while (arr[low] < pivot) low++;
            while (arr[high] > pivot) high--;
            if (low <= high) {
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
                low++;
                high--;
            }
        }
        quickSort(arr, left, low - 1);
        quickSort(arr, low, right);
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
        quickSort(a, 0, n-1);
        System.out.println("< Sort 후 >");
        System.out.println(Arrays.toString(a));
    }
}
