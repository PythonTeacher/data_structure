package org.dimigo.queue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// 우선순위 큐 (정렬 알고리즘 이용하지 말고 풀기)
public class Queue2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Queue queue = new PriorityQueue();

        for (int i = 0; i < n; i++) {
            queue.offer(scanner.nextInt());
        }

        for (int i = 0; i < n; i++) {
            System.out.print(queue.poll() + " ");
        }
    }
}
