package org.dimigo.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 폭탄 제거하기
class Bomb {
    public final int index;
    private int childCount; // 이 폭탄이 터졌을 때 함께 폭발하는 연쇄 폭탄의 수
    private ArrayList<Bomb> parentBombs; // 이 폭탄의 폭발을 유발할 수 있는 폭탄 리스트

    public Bomb(int index) {
        this.index = index;
        this.parentBombs = new ArrayList<>();
        this.childCount = 0;
    }

    public void addParentBombs(Bomb parentBomb) {
        this.parentBombs.add(parentBomb);
        parentBomb.childCount++;
    }

    public ArrayList<Bomb> getParentBombs() {
        return this.parentBombs;
    }

    // 현재 이 폭탄이 제거되었을 때 폭발할 수 있는 폭탄의 수
    public int getChildCount() {
        return childCount;
    }

    public void remove() {
        // 이 폭탄을 제거한다.
        // 그러므로 부모 폭탄들은 연쇄 폭탄 하나가 사라진 꼴이 된다.
        for (int i = 0; i < parentBombs.size(); i++) {
            Bomb p = parentBombs.get(i);
            p.childCount--;
        }
    }
}

public class Queue3_2 {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 문제의 조건에 따라 모든 폭탄을 제거할 수 있는지 판단하는 함수
     *
     * @param n
     * @param bombs
     * @return
     */
    public static boolean isAllRemovable(int n, Bomb[] bombs){
        // 현재 제거 완료된 폭탄들의 목록
        ArrayList<Bomb> removedList = new ArrayList<>();

        // 제거해도 전혀 이상이 없는 폭탄들의 목록
        Queue<Bomb> removableBombs = new LinkedList<>();

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
            Bomb b = removableBombs.poll();
            removedList.add(b);

            // 부모 폭탄들에 대해 연쇄폭탄 정보를 갱신
            b.remove();

            // 이 폭탄의 부모 폭탄들 중, 연쇄 폭탄이 모두 제거된 폭탄들은 제거 가능하므로 큐에 추가한다.
            ArrayList<Bomb> parents = b.getParentBombs();
            for (Bomb bomb : parents) {
                if (bomb.getChildCount() == 0) {
                    removableBombs.add(bomb);
                }
            }
        }

        // 모든 n개의 폭탄이 제거 완료되었다면 true, else false
        if(removedList.size() == n){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();  // 폭탄의 수
        int m = scanner.nextInt();  // 연쇄 관계의 수

        Bomb[] bombs = new Bomb[n+1];   // 1~7
        for (int i = 1; i <= n; i++) {
            bombs[i] = new Bomb(i);
        }

        // 폭탄 U가 해체되면 폭탄 V가 폭발하도록 설정됨
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            Bomb parent = bombs[u];
            Bomb child = bombs[v];

            child.addParentBombs(parent);
        }

        boolean removable = isAllRemovable(n, bombs);

        if(removable){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }

}