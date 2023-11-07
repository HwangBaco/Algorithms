package 코드트리.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;

    private static final int LIVING_SPOT = 1;
    private static int[][] ans;
    private static int res = Integer.MIN_VALUE;
    private static final int NO_ONE_LIVE = 0;

    private static Queue<Pair> q = new LinkedList<>();
    private static Queue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        ans = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == LIVING_SPOT) {
                    q.add(new Pair(i, j));
                }
                arr[i][j] = num;
            }
        }
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, ans[i][j]);
            }
        }
        System.out.println(res);
    }

    private static void bfs() {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int size = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            visited[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                if (canGo(newY, newX)) {
                    visited[newY][newX] = true;
                    q.add(new Pair(newY, newX));
                    ans[newY][newX] = ans[y][x] + 1;
                }
            }
        }


    }
    private static boolean canGo(int y, int x) {
        return inRange(y, x) && arr[y][x] == LIVING_SPOT && !visited[y][x];
    }

    private static boolean inRange(int y, int x) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static class Pair {
        private int x, y;

        private Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

}
