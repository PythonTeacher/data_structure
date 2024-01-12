package org.dimigo.queue;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// 폭탄 제거 순서 정하기 (Priority Queue 사용하기)
class Bomb2 implements Comparable<Bomb2> {
    public final int index;
    private int childCount;
    private ArrayList<Bomb2> parentBombs;

    public Bomb2(int index) {
        this.index = index;
        this.parentBombs = new ArrayList<>();
        this.childCount = 0;
    }

    public void addParentBombs(Bomb2 parentBomb) {
        this.parentBombs.add(parentBomb);
        parentBomb.childCount += 1;
    }

    public ArrayList<Bomb2> getParentBombs() {
        return this.parentBombs;
    }

    public int getChildCount() {
        return childCount;
    }

    public void remove() {
        for (int i = 0; i < parentBombs.size(); i++) {
            Bomb2 p = parentBombs.get(i);
            p.childCount--;
        }
    }

    @Override
    public int compareTo(Bomb2 o) {
        // 인덱스가 작을수록 priorityQueue에서 먼저 poll 되도록 우선순위를 정의한다.
        return this.index - o.index;
    }
}

public class Queue3_3 {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 문제의 조건에 따라 모든 폭탄을 제거할 수 있는지 판단하는 함수
     *
     * @param n
     * @param bombs
     * @return
     */
    public static void isAllRemovable(int n, Bomb2[] bombs){
        // 현재 제거 완료된 폭탄들의 목록
        ArrayList<Bomb2> removedList = new ArrayList<>();

        // 제거해도 전혀 이상이 없는 폭탄들의 목록
        // pool시에 제거 가능한 폭탄들 중 가장 인덱스가 작은 번호가 반환될 수 있도록
        // PriorityQueue를 사용한다. 폭탄들의 우선순위는 compareTo 메소드로 정의한다.
        PriorityQueue<Bomb2> removableBombs = new PriorityQueue<>();

        // 제거 가능한 노드를 Queue에 추가
        for (int i = 1; i < n + 1; i++) {
            // 현재 연쇄 폭탄이 없는 폭탄들은 제거 가능한 목록에 추가한다.
            if (bombs[i].getChildCount() == 0) {
                removableBombs.add(bombs[i]);
            }
        }

        // 큐에 있는 폭탄들을 차례로 제거해 나간다.
        while (!removableBombs.isEmpty()) {
            // 현재 연쇄폭탄이 없는 폭탄을 제거
            Bomb2 b = removableBombs.poll();
            removedList.add(b);

            // 부모 폭탄들에 대해 연쇄폭탄 정보를 갱신
            b.remove();

            // 이 폭탄의 부모 폭탄들 중, 연쇄 폭탄이 모두 제거된 폭탄들은 제거 가능하므로 큐에 추가한다.
            ArrayList<Bomb2> parents = b.getParentBombs();
            for (Bomb2 bomb : parents) {
                if (bomb.getChildCount() == 0) {
                    removableBombs.add(bomb);
                }
            }
        }

        // 모든 n개의 폭탄이 제거 완료되었다면 true, else false
        if(removedList.size() == n){
            for (int i = 0; i < removedList.size(); i++) {
                System.out.print(removedList.get(i).index);
                if (i < removedList.size() - 1)
                    System.out.print(" ");
            }
        }else{
            System.out.println("NO");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();  // 폭탄의 수
        int m = scanner.nextInt();  // 연쇄 관계의 수

        Bomb2[] bombs = new Bomb2[n+1];   // 1~7
        for (int i = 1; i <= n; i++) {
            bombs[i] = new Bomb2(i);
        }

        // 폭탄 U가 해체되면 폭탄 V가 폭발하도록 설정됨
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            Bomb2 parent = bombs[u];
            Bomb2 child = bombs[v];

            child.addParentBombs(parent);
        }

        isAllRemovable(n, bombs);
    }

}