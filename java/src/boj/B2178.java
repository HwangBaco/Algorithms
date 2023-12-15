package 백준;/*
 * BFS
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static boolean[][] visited;
    static int n, m;
    public static void main(String[] args) throws IOException {
        // 기본 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }
        BFS(0, 0);
        bw.write(Integer.toString(arr[n - 1][m - 1]));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] && arr[x][y] != 0) {
                    arr[x][y] = arr[now[0]][now[1]] + 1;
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }

    }

}
