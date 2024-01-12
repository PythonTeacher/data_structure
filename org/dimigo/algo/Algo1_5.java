package org.dimigo.algo;

import java.util.Scanner;

// 그리디 알고리즘 (최소비용 신장트리 - Prim)
public class Algo1_5 {

    static int cost;
    static int[][] adj;
    static int[] visited;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();    // 정점의 개수
        int e = s.nextInt();    // 간선의 개수

        adj = new int[v+1][v+1];     // 가중치 인접행렬
        visited = new int[v+1];

        // 간선의 개수만큼 가중치가 입력 (A B C -> A B 정점의 간선 가중치 C)
        for (int i = 0; i < e; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            adj[a][b] = c;
            adj[b][a] = c;
        }

        visited[1] = 1;
        mst(1);

        System.out.println(cost);
    }

    public static void mst(int count) {
        if (count == visited.length - 1) return;
        int min = Integer.MAX_VALUE;
        int add = 0;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == 1) {
                for (int j = 1; j < adj.length; j++) {
                    if (i == j || visited[j] == 1 || adj[i][j] == 0) continue;
                    // 연결되지 않은 노드중 가장 작은 값을 가지는 노드를 추가
                    if (adj[i][j] < min) {
                        min = adj[i][j];
                        add = j;
                    }
                }
            }
        }

        visited[add] = 1;
        cost += min;
        mst(count + 1);
    }
}
