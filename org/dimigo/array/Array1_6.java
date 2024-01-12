package org.dimigo.array;

import java.util.Arrays;

// 순열 확인 : 문자열 두개가 서로 순열 관계에 있는지 판별하기
// 순열이라는 것은 서로가 문자열의 종류와 숫자가 같으면서 배열된 순서가 다른 것을 말한다.
public class Array1_6 {
    // 순열이라면 두 문자열의 길이가 같고 각각의 문자열을 정렬한 결과가, 같은 문자열이 되어야 한다.
    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static boolean permutation(String s, String t) {
        if(s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
    }

    // ASCII 코드로 풀기
    public static boolean permutation2(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] letters = new int[128];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation2(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
