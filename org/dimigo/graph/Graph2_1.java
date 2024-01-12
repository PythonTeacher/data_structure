package org.dimigo.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로탐색 (BFS)
 */
class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Graph2_1 {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        visited[0][0] = true;
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 1 && !visited[nx][ny]) {
                        q.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[p.x][p.y] + 1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(dist[n-1][m-1]);

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }*/
    }
}