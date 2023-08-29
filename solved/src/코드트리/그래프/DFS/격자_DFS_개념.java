package 코드트리.그래프.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 격자_DFS_개념 {
    public static int[][] grid = new int[][]{
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1},
            {0, 0, 1, 0, 1}
    };
    public static int[][] visited = new int[5][5];
    public static int[][] answer = new int[5][5];
    public static int order = 1;
    public static void main(String[] args) throws IOException {
        answer[0][0] = order++;
        visited[0][0] = 1;

        DFS(0, 0);
        System.out.println(answer[4][4]);

    }

    public static void DFS(int r, int c) {
        int[] dc = new int[]{1, 0}; // 오른쪽, 아래 순
        int[] dr = new int[]{0, 1};

        for (int i = 0; i < 2; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];
            if (canGo(newR, newC)) {
                answer[newR][newC] = order++;
                visited[newR][newC] = 1;
                DFS(newR, newC);
            }
        }
    }

    public static boolean canGo(int r, int c) {
        if (!inRange(r, c)) {
            return false;
        }
        if (visited[r][c] == 1 || grid[r][c] == 0) {
            return false;
        }
        return true;
    }

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < 5 && 0 <= c && c < 5;
    }
}
