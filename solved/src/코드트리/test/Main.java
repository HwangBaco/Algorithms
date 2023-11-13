package 코드트리.test;

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;

    private static boolean hasSize;
    private static Map<Integer, Integer> m = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    hasSize = false;
                    visited[i][j] = true;
                    dfs(new Pair(i, j), arr[i][j]);
                    if (hasSize) {
                        m.putIfAbsent(arr[i][j], 1);
                        m.replace(arr[i][j], m.get(arr[i][j]) + 1);
                    }
                }
            }
        }
        for (int i = 1; i <= 3; i++) {
            System.out.print(m.get(i) + " ");
        }



    }

    private static void dfs(Pair p, int type) {
        int[] dy = new int[]{1, 0, -1, 0};
        int[] dx = new int[]{0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newY = p.y + dy[i];
            int newX = p.x + dx[i];

            if (canGo(newY, newX, type)) {
                visited[newY][newX] = true;
                dfs(new Pair(newY, newX), type);
                hasSize = true;
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static boolean canGo(int y, int x, int type) {
        return inRange(y, x) && arr[y][x] == type && !visited[y][x];
    }

    private static class Pair {
        private int x, y;

        private Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
