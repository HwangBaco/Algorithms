package 코드트리.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_TEST {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;

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
        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken())-1;
        int startX = Integer.parseInt(st.nextToken())-1;
        visited[startY][startX] = true;
        dfs(new Pair(startY, startX));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    System.out.print(0 + " ");
                } else if (visited[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    private static void dfs(Pair crt) {
        int[] dx = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};

        for (int i = 0; i < 8; i++) {
            int newY = crt.y + dy[i];
            int newX = crt.x + dx[i];
            if (canGo(newY, newX)) {
                visited[newY][newX] = true;
                dfs(new Pair(newY, newX));
            }
        }
    }

    private static boolean canGo(int y, int x) {
        return inRange(y, x) && arr[y][x] == 0 && !visited[y][x];
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static class Pair {
        private int x, y;

        private Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

}
