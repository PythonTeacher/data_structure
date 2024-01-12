package org.dimigo.array;

// 회문 순열 : 주어진 문자열이 회문(palindrome)의 순열인지 아닌지 확인하기 (대소문자는 무시)
// 회문이란 앞으로 읽으나 뒤로 읽으나 같은 단어 혹은 구절을 의미한다.
public class Array1_8 {
    public static boolean isPalindrome(String s) {
        int length = s.length();
        char[] arr = s.toLowerCase().toCharArray();

        for (int i = 0; i < length / 2; i++) {
            if (arr[i] != arr[length - i - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "aaa",
                "tacocat",
                "atcocta"};
        for (String s : strings) {
            System.out.println(isPalindrome(s));
        }
    }
}
