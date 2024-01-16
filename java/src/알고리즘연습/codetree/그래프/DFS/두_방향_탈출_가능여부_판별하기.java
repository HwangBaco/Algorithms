package 코드트리.그래프.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두_방향_탈출_가능여부_판별하기 {
    /*
     * 좌표 이동시 반드시 아래와 오른쪽 2방향 중 인접한 칸으로만 가능
     **/
    public static int[] dr = new int[]{1, 0}; // 아래, 오른쪽 순
    public static int[] dc = new int[]{0, 1};
    public static int[][] grid;
    public static int[][] visited;
    public static int[][] answer;
    public static int order = 1;
    public static int n,m;

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
        answer = new int[n][m];
        answer[0][0] = order++;
        visited[0][0] = 1;
        DFS(0, 0);
        System.out.println(answer[n-1][m-1] > 0 ? 1 : 0);
    }

    public static void DFS(int r, int c) {
        for (int i = 0; i < 2; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];
            if (canGo(newR, newC)) {
                visited[newR][newC] = 1;
                answer[newR][newC] = order++;
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
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
