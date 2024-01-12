package org.dimigo.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 카드
public class Queue1_4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            queue.poll();           // 위 한장은 버림
            int t = queue.poll();   // 그 다음 한장을 꺼내어
            queue.offer(t);         // 밑으로 다시 넣음
        }

        System.out.println(queue.poll());
    }
}
