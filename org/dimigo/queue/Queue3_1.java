package org.dimigo.queue;

import java.util.LinkedList;
import java.util.Scanner;

// 프린터 큐
class Doc {
    int priority;
    int index;
    public Doc(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}

public class Queue3_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();        // 문서 수
        int k = s.nextInt();        // 알고 싶은 문서 위치(0부터 시작)
        LinkedList<Doc> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int t = s.nextInt();
            queue.offer(new Doc(t, i));
        }

        boolean flag = false;
        int cnt = 0;
        while (!queue.isEmpty()) {
            Doc doc = queue.poll();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.get(i).priority > doc.priority) {
                    queue.offer(doc);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                cnt++;
                if (doc.index == k) {
                    System.out.println(cnt);
                    return;
                }
            }
            flag = false;
        }
    }
}