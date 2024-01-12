package org.dimigo.array;

import java.util.Scanner;

// 행렬 곱 계산하기 (난이도:상)
public class Array3_1 {
    int[][] m1 = null;
    int[][] m2 = null;
    int r1, c1, r2, c2;

    private void inputData() {
        Scanner s = new Scanner(System.in);

        // 첫번째 행렬
        r1 = s.nextInt();
        c1 = s.nextInt();
        m1 = new int[r1][c1];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                m1[i][j] = s.nextInt();
            }
        }

        // 두번째 행렬
        r2 = s.nextInt();
        c2 = s.nextInt();
        m2 = new int[r2][c2];

        for (int i = 0; i < r2; i++) {
            for(int j = 0; j < c2; j++) {
                m2[i][j] = s.nextInt();
            }
        }
    }

    private void printData(int[][] matrix) {
        for(int[] data : matrix) {
            for(int value : data) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private int[][] multiplyMatrix() {
        int[][] answer = new int[r1][c2];   // r1Xc1 * r2Xc2 = r1Xc2

        for (int i = 0; i < r1; i++){  // 2
            for (int j = 0; j < c2; j++){  // 2
                for (int k = 0; k < c1; k++){  // 1
                    answer[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Array3_1 obj = new Array3_1();
        obj.inputData();
        //obj.printData(obj.m1);
        //obj.printData(obj.m2);
        int[][] result = obj.multiplyMatrix();
        obj.printData(result);
    }

}
