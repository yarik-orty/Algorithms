package org.makefun.graph;

public class Run {

    public static void main(final String[] args) {
        final Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.print();

        System.out.println();

        graph.dfs(4);
    }
}
