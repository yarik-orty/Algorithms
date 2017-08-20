package org.makefun.path;

import org.makefun.DataSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class PathFind {

    public static final int ROW = 10;
    public static final int COL = 10;

    public static final int CELL = 8;
    public static final int START = 2;
    public static final int GOAL = 8;

    public static final int ROW_NBR[] = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
    public static final int COL_NBR[] = new int[]{1, -1, 0, 1, -1, -1, 0, 1};

    private Item start;
    private Item goal;

    public static void main(String[] args) {
        PathFind pathFind = new PathFind();
        pathFind.run(DataSet.input);
    }

    void run(int input[][]) {
        Item visited[][] = new Item[ROW][COL];
        findStartEnd(input);
        bfs(input, start.x, start.y, visited);
    }

    private void bfs(int arr[][], int row, int col, Item visited[][]) {
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(row, col));

        visited[row][col] = null;

        while (!queue.isEmpty()) {
            Item current = queue.poll();
            int i = current.x;
            int j = current.y;
            for (int k = 0; k < CELL; k++) {
                if (isEnded(arr, i + ROW_NBR[k], j + COL_NBR[k], visited)) {
                    queue.clear();
                    visited[i + ROW_NBR[k]][j + COL_NBR[k]] = current;
                    printPath(arr, visited, i + ROW_NBR[k], j + COL_NBR[k]);
                    break;
                }
                if (isSafe(arr, i + ROW_NBR[k], j + COL_NBR[k], visited)) {
                    int priority = heuristic(goal, current);
                    visited[i + ROW_NBR[k]][j + COL_NBR[k]] = current;
                    queue.add(new Item(i + ROW_NBR[k], j + COL_NBR[k], priority));
                }
            }
        }
    }

    private int heuristic(Item a, Item b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private void printPath(int arr[][], Item visited[][], int xEnd, int yEnd) {
        Item current = visited[xEnd][yEnd];
        List<Item> path = new ArrayList<>();
        while (!start.equals(current)) {
            path.add(current);
            current = visited[current.x][current.y];
        }

        path.forEach(it -> arr[it.x][it.y] = 2);
        System.out.println("Step = " + path.size());
        print(arr);
    }

    private void findStartEnd(int arr[][]) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (arr[i][j] == START) {
                    this.start = new Item(i, j);
                }
                if (arr[i][j] == GOAL) {
                    this.goal = new Item(i, j);
                }
            }
        }
    }

    private void print(int arr[][]) {
        for (int i = 0; i < ROW; i++) {
            System.out.println();
            for (int j = 0; j < COL; j++) {
                System.out.print(arr[i][j] + ", ");
            }
        }
    }

    private boolean isEnded(int[][] arr, int row, int col, Item[][] visited) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && (arr[row][col] == GOAL && visited[row][col] == null);
    }

    private boolean isSafe(int[][] arr, int row, int col, Item[][] visited) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && (arr[row][col] == 0 && visited[row][col] == null);
    }
}
