package org.makefun.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public final class Graph {

    private final List<List<Integer>> adjacent;
    private final int vertices;

    public Graph(final int v) {
        this.vertices = v;
        this.adjacent = new ArrayList<>(v);
        initAdj();
    }

    public void addEdge(final int x, final int y) {
        if (x > vertices || y > vertices) throw new IllegalArgumentException("Out of bound vertex");
        adjacent.get(x).add(y);
        adjacent.get(y).add(x);
    }

    public void dfs(final int vertex) {
        boolean[] visited = new boolean[vertices];
        dfs(vertex, visited);
    }

    public void print() {
        for (int i = 0; i < vertices; i++) {
            System.out.println("\nAdjacency list of vertex " + i);
            System.out.print("head");
            for (int j = 0; j < adjacent.get(i).size(); j++) {
                System.out.print(" -> " + adjacent.get(i).get(j));
            }
            System.out.println();
        }
    }

    private void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(" -> " + vertex);
        // Recur for all vertices adjacent to current vertex
        ListIterator<Integer> iterator = adjacent.get(vertex).listIterator();
        while (iterator.hasNext()) {
            int v = iterator.next();
            if (!visited[v]) {
                dfs(v, visited);
            }
        }
    }

    private void initAdj() {
        for (int i = 0; i < vertices; i++) {
            this.adjacent.add(new ArrayList<>());
        }
    }
}
