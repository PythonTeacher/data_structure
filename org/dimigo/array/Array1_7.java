package org.dimigo.array;

import java.util.Arrays;

// URL화 : 문자열의 모든 공백을 '%20'으로 바꿔주는 메소드를 작성하기
// 문자 배열 사용하기
public class Array1_7 {

    public static int countSpace(String s) {
        int cnt = 0;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == ' ') cnt++;
        }
        return cnt;
    }

    public static void makeArray(String s, char[] arr) {
        int size = s.length();
        int index = 0;
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                arr[index++] = '%';
                arr[index++] = '2';
                arr[index++] = '0';
            } else {
                arr[index++] = c;
            }
        }
    }

    public static void main(String[] args) {
        String s = "Mr John Smith ";
        int cnt = countSpace(s);
        char[] arr = new char[s.length() + cnt * 2];
        makeArray(s, arr);
        System.out.println(Arrays.toString(arr));
    }
}
