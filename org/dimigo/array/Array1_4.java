package org.dimigo.array;

import java.util.Scanner;

// C를 찾아라 (난이도:하)
public class Array1_4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        char[] arr = str.toLowerCase().toCharArray();
        int cnt = 0, cnt2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'c') cnt++;
            if (i < arr.length - 1 && arr[i] == 'c' && arr[i+1] == 'c') cnt2++;
        }
        System.out.println(cnt);
        System.out.println(cnt2);
    }
}
