package 코드트리.그래프.BFS;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 돌_잘_치우기 {
    private static int n, m, k;
    private static int[][] grid;
    private static int[][] moved;
    private static int[][] visited;
    private static Queue<Integer> pq = new PriorityQueue<>();

    private static Queue<Pair> q = new LinkedList<>();
    private static class Pair {
        private int x, y;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static boolean canGo(int y, int x, int[][] grid, int[][] visited) {
        if (!inRange(y, x) || grid[y][x] == 1 || visited[y][x] == 1) {
            return false;
        }
        return true;
    }
    private static boolean canThrough(int y, int x, int[][] grid) {
        if (inRange(y, x) && grid[y][x] == 1 && moved[y][x] == 0 && k > 0) {
            return true;
        }
        return false;
    }

    private static void push(int y, int x) {
        visited[y][x] = 1;
        q.add(new Pair(y, x));
    }

    private static void DFS(int y, int x, int[][] grid, int startY, int startX) {
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (canGo(newY, newX, grid, moved)) {
                moved[newY][newX] = 1;
                DFS(newY, newX, grid, startY, startX);
            } else if (canThrough(newY, newX, grid)) {
                k--;
                grid[newY][newX] = 0;
                moved[newY][newX] = 1;
                if (k == 0) {
                    push(startY, startX);
                    BFS(grid);
                } else {
                    DFS(newY, newX, grid, startY, startX);
                }
            }
        }
    }
    private static void BFS(int[][] grid) {
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{1, 0, -1, 0};
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y;
            int x = curr.x;
            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                if (canGo(newY, newX, grid, visited)) {
                    push(newY, newY);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < m; i++) {

        }
    }
}
