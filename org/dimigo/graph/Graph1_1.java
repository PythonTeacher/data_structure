package org.dimigo.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 인접행렬로 그래프 구현하기 (무방향 그래프)
 */
class Graph {
    private int matrix[][];
    private int size;           // 정점의 개수
    private boolean[] visited;  // 방문 여부

    public Graph(int size) {
        matrix = new int[size][size];
        this.size = size;
        visited = new boolean[size];
    }

    private void checkVertex(int v1, int v2) {
        if (v1 < 0 || v1 >= size) throw new IndexOutOfBoundsException("Index: "+ v1 + ", Size: " + size);
        if (v2 < 0 || v2 >= size) throw new IndexOutOfBoundsException("Index: "+ v2 + ", Size: " + size);
    }

    // 가중치 그래프의 경우 가중치 값을 저장하기
    public void addEdge(int v1, int v2) {
        checkVertex(v1, v2);
        matrix[v1][v2] = matrix[v2][v1] = 1;
    }

    public void removeEdge(int v1, int v2) {
        checkVertex(v1, v2);
        matrix[v1][v2] = matrix[v2][v1] = 0;
    }

    public boolean existsEdge(int v1, int v2) {
        checkVertex(v1, v2);
        return matrix[v1][v2] == 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(i + ": ");
//            for (int j : matrix[i]) {
//                s.append(j + " ");
//            }
            for (int j = 0; j < size; j++) {
                s.append(matrix[i][j] + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    // DFS : 재귀 호출
    public void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < size; i++) {
            if (matrix[v][i] == 1 && !visited[i]) {     // matrix[i][v]도 동일
                dfs(i);
            }
        }
    }

    // DFS : 스택 이용
    public void dfs2(int v) {
        Stack<Integer> stack = new Stack();
        stack.push(v);
        visited[v] = true;
        System.out.print(v + " ");
        boolean found;

        while (!stack.isEmpty()) {
            int cur = stack.peek();
            found = false;
            for (int i = 0; i < size; i++) {
                if (matrix[cur][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                    found = true;
                    break;
                }
            }
            if (!found) stack.pop();
        }
    }

    public void initVisited() {
        for(int i = 0; i < size; i++) {
            visited[i] = false;
        }
    }

    // BFS : Queue 이용
    public void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            for (int i = 0; i < size; i++) {
                if (matrix[cur][i] == 1 && !visited[i]) {
                    q.add(i);   // offer도 가능
                    visited[i] = true;
                }
            }
        }
    }

    public void bfs2(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (visited[cur]) continue;
            visited[cur] = true;
            System.out.print(cur + " ");
            for (int i = 0; i < size; i++) {
                if (matrix[cur][i] == 1) {
                    q.add(i);   // offer도 가능
                }
            }
        }
    }
}

public class Graph1_1 {

    public static void main2(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        System.out.println(g);

        g.removeEdge(1, 2);
        System.out.println(g);

        System.out.println(g.existsEdge(2, 3));
        System.out.println(g.existsEdge(0, 2));
    }

    /*
              (0)
            /     \
          (1)     (2)
         /  \    /  \
       (3)  (4) (5) (6)
        \    |   |   /
         \   |  |  /
             (7)
     */
    public static void main(String[] args) {
        Graph g = new Graph(8);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 7);
        g.addEdge(4, 7);
        g.addEdge(5, 7);
        g.addEdge(6, 7);

        System.out.println(g);

        g.dfs(0);
        System.out.println();

        g.initVisited();
        g.dfs(1);
        System.out.println();

        g.initVisited();
        g.dfs2(0);
        System.out.println();

        g.initVisited();
        g.dfs2(1);
        System.out.println();

        g.initVisited();
        g.bfs(0);
        System.out.println();

        g.initVisited();
        g.bfs(1);
        System.out.println();

        g.initVisited();
        g.bfs2(0);
        System.out.println();

        g.initVisited();
        g.bfs2(1);
    }
}
