package org.dimigo.array;

// 중복찾기 : 문자열에 같은 알파벳이 등장하는지 확인하는 알고리즘을 작성하기
public class Array1_5 {
    public static boolean isUnique(String str) {
        boolean[] charSet = new boolean[26*2];
        int size = str.length();
        for (int i = 0; i < size; i++) {
            int val = str.charAt(i);
            if (val >= 'A' && val <= 'Z') {         // 0 ~ 25
                if (charSet[val - 'A']) return false;
                charSet[val - 'A'] = true;
            }
            if (val >= 'a' && val <= 'z') {  // 26 ~ 51
                if (charSet[val - 'a' + 26]) return false;
                charSet[val - 'a' + 26] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "padDle", "paddle"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique(word));
        }
    }
}
