package org.dimigo.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex {
    int data;
    LinkedList<Vertex> adjacent;
    boolean visited;
    public Vertex(int data) {
        this.data = data;
        this.visited = false;
        adjacent = new LinkedList<>();
    }
}

class Graph2 {
    private Vertex[] heads;
    private int size;       // 정점 개수

    public Graph2(int size) {
        this.heads = new Vertex[size];
        for (int i = 0; i < size; i++)
            heads[i] = new Vertex(i);
        this.size = size;
    }

    private void checkVertex(int v1, int v2) {
        if (v1 < 0 || v1 >= size) throw new IndexOutOfBoundsException("Index: "+ v1 + ", Size: " + size);
        if (v2 < 0 || v2 >= size) throw new IndexOutOfBoundsException("Index: "+ v2 + ", Size: " + size);
    }

    public void addEdge(int v1, int v2) {
        checkVertex(v1, v2);
        Vertex a = heads[v1];
        Vertex b = heads[v2];

        if (!a.adjacent.contains(b)) {
            a.adjacent.add(b);
        }
        if (!b.adjacent.contains(a)) {
            b.adjacent.add(a);
        }
    }

    public void removeEdge(int v1, int v2) {
        checkVertex(v1, v2);
        Vertex a = heads[v1];
        Vertex b = heads[v2];
        a.adjacent.remove(b);     // 삭제 성공 true, 아니면 false
        b.adjacent.remove(a);
    }

    public boolean existsEdge(int v1, int v2) {
        checkVertex(v1, v2);
        Vertex a = heads[v1];
        Vertex b = heads[v2];
        //return a.adjacent.indexOf(b) >= 0;
        return a.adjacent.contains(b);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(heads[i].data + ": ");
            for (Vertex n : heads[i].adjacent) {
                s.append(n.data + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void dfs(int index) {
        dfs(heads[index]);
    }

    // DFS : 재귀 호출
    public void dfs(Vertex v) {
        //if (v == null) return;
        v.visited = true;
        System.out.print(v.data + " ");
        for (Vertex n : v.adjacent) {
            if (!n.visited) {
                dfs(n);
            }
        }
    }

    // DFS : 스택 이용
    public void dfs2(int index) {
        Stack<Vertex> stack = new Stack<>();
        Vertex v = heads[index];
        stack.push(v);
        v.visited = true;
        System.out.print(v.data + " ");
        boolean found;

        while (!stack.isEmpty()) {
            Vertex cur = stack.peek();
            found = false;
            for (Vertex n : cur.adjacent) {
                if (!n.visited) {
                    stack.push(n);
                    n.visited = true;
                    System.out.print(n.data + " ");
                    found = true;
                    break;
                }
            }
            if (!found) stack.pop();
        }
    }

    public void initVisited() {
        for(Vertex v : heads) {
            v.visited = false;
        }
    }

    // BFS : Queue 이용
    public void bfs(int index) {
        Vertex v = heads[index];
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);   // offer도 가능
        v.visited = true;
        while (!queue.isEmpty()) {
            Vertex cur = queue.poll();
            System.out.print(cur.data + " ");
            for (Vertex n : cur.adjacent) {
                if (!n.visited) {
                    n.visited = true;
                    queue.offer(n);
                }
            }
        }
    }

    public void bfs2(int index) {
        Queue<Vertex> q = new LinkedList<>();
        Vertex v = heads[index];
        q.add(v);
        while (!q.isEmpty()) {
            Vertex cur = q.poll();
            if (cur.visited) continue;
            cur.visited = true;
            System.out.print(cur.data + " ");
            for (Vertex n : cur.adjacent) {
                if (!n.visited) {
                    q.add(n);   // offer도 가능
                }
            }
        }
    }
}

public class Graph1_2 {
    public static void main2(String args[]) {
        Graph2 g = new Graph2(4);

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
        Graph2 g = new Graph2(8);

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
        System.out.println();
    }
}