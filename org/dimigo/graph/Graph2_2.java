package org.dimigo.graph;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 연결요소 (Connected Component) 개수 구하기
 */
public class Graph2_2 {

    public static void dfs(LinkedList<Integer>[] a, boolean[] visited, int x) {
        if (visited[x]) return;
        visited[x] = true;
        for (int y : a[x]) {
            if (!visited[y]) {
                dfs(a, visited, y);
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 정점의 수
        int m = sc.nextInt();   // 간선의 수
        LinkedList<Integer>[] a = new LinkedList[n+1];

        for (int i = 1; i <= n; i++) {
            a[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }

        boolean[] visited = new boolean[n+1];
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(a, visited, i);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
