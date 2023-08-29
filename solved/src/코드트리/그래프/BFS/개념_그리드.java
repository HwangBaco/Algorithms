package 코드트리.그래프.BFS;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class 개념_그리드 {
    private static int[][] grid = new int[][]{
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1},
            {0, 0, 1, 0, 1}
    };

    private static int[][] visited = new int[5][5];
    private static int[][] answer = new int[5][5];
    private static int order = 1;
    private static Queue<Pair> q = new LinkedList<>();

    private static boolean inRange(int y, int x) {
        return 0 <= x && x < 5 && 0 <= y && y < 5;
    }

    private static boolean canGo(int y, int x) {
        if (!inRange(y, x) || visited[y][x] == 1 || grid[y][x] == 0) {
            return false;
        }
        return true;
    }

    private static void push(int y, int x) {
        answer[y][x] = order++;
        visited[y][x] = 1;
        q.add(new Pair(y, x));
    }

    public static class Pair {
        private int y;
        private int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void BFS() {
        int[] dy = new int[]{1, 0};
        int[] dx = new int[]{0, 1};

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;

            for (int i = 0; i < 2; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                if (canGo(newY, newX)) {
                    push(newY, newX);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        push(0, 0);
        BFS();
    }
}
