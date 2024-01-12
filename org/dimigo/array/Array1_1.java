package org.dimigo.array;

import java.util.Random;
import java.util.Scanner;

// 랜덤하게 생성된 숫자의 갯수 출력하기 (난이도:하)
public class Array1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. 입력받은 수 만큼 배열 생성
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] cnt = new int[5];

        // 2. 입력받은 값 배열에 할당
        for(int i=0; i<n; i++) {
            // 4. 랜덤값 할당
            arr[i] = new Random().nextInt(5);
            cnt[arr[i]]++;
        }

        // 3. 입력받은 값 출력
        System.out.print("배열 : [");
        for(int i=0; i<n; i++) {
            if(i == n-1) System.out.print(arr[i]);
            else System.out.print(arr[i] + ", ");
        }
        System.out.println("]");

        // 5. 숫자 개수 출력하기
        for(int i=0; i<cnt.length; i++) {
            System.out.println(i + "의 개수:" + cnt[i]);
        }
    }
}
