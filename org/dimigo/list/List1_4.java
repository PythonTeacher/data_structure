package org.dimigo.list;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

// 정렬되어 있지 않은 데이터를 연결리스트를 이용하여 중복 제거하기
public class List1_4 {

    static void removeDup(LinkedList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Integer data = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) == data) {
                    list.remove(j--);
                }
            }
        }
        printAll(list.iterator());
    }

    static void removeDup2(LinkedList<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }
        printAll(set.iterator());
    }

    static void printAll(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(s.nextInt());
        }
        //System.out.println(list);
        removeDup(list);
        //System.out.println(list);
    }
}
