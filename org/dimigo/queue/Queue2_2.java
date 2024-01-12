package org.dimigo.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 조세퍼스 순열
public class Queue2_2 {
    static Queue<Integer> makeQueue(int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        return queue;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

        Queue<Integer> queue = makeQueue(n);
        int cnt = 0;
        while (!queue.isEmpty()) {
            if (++cnt % k != 0) {
                int t = queue.poll();
                queue.offer(t);
            } else {
                System.out.print(queue.poll() + " ");
                //if(queue.size() >= 1) System.out.print(", ");
            }
        }
    }
}
