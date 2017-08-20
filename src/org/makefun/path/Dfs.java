package org.makefun.path;

import java.util.LinkedList;
import java.util.Queue;

public class Dfs {

    public static final int ROW = 5;
    public static final int COL = 5;

    public static final int CELL = 8;

    public static final int ROW_NBR[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    public static final int COL_NBR[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        int input[][] = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        Dfs main = new Dfs();
        int count = main.count(input);

        System.out.println("Result = " + count);
    }

    private void dfs(int arr[][], int row, int col, boolean visited[][]) {
        visited[row][col] = true;

        for (int k = 0; k < CELL; k++) {
            if (checkCondition(arr, row + ROW_NBR[k], col + COL_NBR[k], visited)) {
                dfs(arr, row + ROW_NBR[k], col + COL_NBR[k], visited);
            }
        }
    }

    private void bfs(int arr[][], int row, int col, boolean visited[][]) {
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(row, col));

        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            int i = item.x;
            int j = item.y;
            for (int k = 0; k < CELL; k++) {
                if (checkCondition(arr, i + ROW_NBR[k], j + COL_NBR[k], visited)) {
                    visited[i + ROW_NBR[k]][j + COL_NBR[k]] = true;
                    queue.add(new Item(i + ROW_NBR[k], j + COL_NBR[k]));
                }
            }
        }
    }

    private boolean checkCondition(int arr[][], int row, int col, boolean visited[][]) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && (arr[row][col] == 1 && !visited[row][col]);
    }

    private int count(int arr[][]) {
        boolean visited[][] = new boolean[ROW][COL];
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    bfs(arr, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
}
