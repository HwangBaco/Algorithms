package 코드트리.그래프.BFS;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그리드_탈출여부_판별 {
    private static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static Queue<Pair> q = new LinkedList<>();
    private static int[][] grid;
    private static int[][] visited;
    private static int n, m;

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    private static boolean canGo(int y, int x) {
        if (!inRange(y, x) || grid[y][x] == 0 || visited[y][x] == 1) {
            return false;
        }
        return true;
    }

    private static void push(int y, int x) {
        visited[y][x] = 1;
        q.add(new Pair(y, x));
    }

    private static void BFS() {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y;
            int x = curr.x;


            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];

                if (canGo(newY, newX)) {
                    grid[newY][newX] = -1;
                    push(newY, newX);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        push(0, 0);
        BFS();
        System.out.println(grid[n-1][m-1] == -1 ? 1 : 0);
    }
}
