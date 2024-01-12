package org.dimigo.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Test {
    public static void main2(String[] args) {
        // create variables
        ArrayList<Integer> a = new ArrayList<Integer>();
        LinkedList<Integer> b = new LinkedList<Integer>();
        Random rand = new Random();

        // init
        for (int i = 1; i <= 1000000; i++) {
            a.add(i);
            b.add(i);
        }
        // compare random access
        long start, end;
        start = System.nanoTime();
        a.get(rand.nextInt(a.size()));
        end = System.nanoTime();
        System.out.printf("랜덤 접근 시간: %dns (ArrayList)\n", end - start);

        start = System.nanoTime();
        b.get(rand.nextInt(a.size()));
        end = System.nanoTime();
        System.out.printf("랜덤 접근 시간: %dns (LinkedList)\n", end - start);
    }

    public static void main(String[] args) {
        // create variables
        ArrayList<Integer> a = new ArrayList<Integer>();
        LinkedList<Integer> b = new LinkedList<Integer>();
        Random rand = new Random();

        // init
        for (int i = 1; i <= 1000000; i++) {
            a.add(i);
            b.add(i);
        }
        // compare random access
        long start, end;
        start = System.nanoTime();
        //a.remove(rand.nextInt(a.size()));
        a.add(rand.nextInt(a.size()), 100);
        end = System.nanoTime();
        System.out.printf("랜덤 요소 삭제 시간: %dns (ArrayList)\n", end - start);

        start = System.nanoTime();
        //b.remove(rand.nextInt(b.size()));
        b.add(rand.nextInt(b.size()), 100);
        end = System.nanoTime();
        System.out.printf("랜덤 요소 삭제 시간: %dns (LinkedList)\n", end - start);
    }
}
