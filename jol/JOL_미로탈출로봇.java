package 알고리즘연습.jol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class JOL_미로탈출로봇 {
    /**
     * 실행 시간 : 265 ms
     *
     * 메모리 : 42.3 MB
     */
    private static int R, C;
    private static int[][] grid;
    private static boolean[][] visited;
    private static int[][] res;
    private static int startY, startX, endY, endX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        grid = new int[R][C];
        res = new int[R][C];
        visited = new boolean[R][C];


        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;
        endX = Integer.parseInt(st.nextToken()) - 1;
        endY = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = Integer.parseInt(s.substring(j, j + 1));
                res[i][j] = (int) 1e9;
            }
        }
//        bfs();
        res[startY][startX] = 0;
        dfs(startY, startX);
        System.out.println(res[endY][endX]);
    }

    private static void dfs(int y, int x) {
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        int step = res[y][x] + 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (inRange(ny, nx) && grid[ny][nx] == 0 && res[ny][nx] > step) {
                res[ny][nx] = step;
                if (ny == endY && nx == endX) {
                    return;
                }
                dfs(ny, nx);
            }
        }
    }

    private static void bfs() {
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        Queue<int[]> q = new ArrayDeque<>(); // (y, x)

        q.add(new int[]{startY, startX});
        visited[startY][startX] = true;

        top:
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];



            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (canGo(ny, nx)) {
                    if (ny == endY && nx == endX) {
                        res[ny][nx] = res[y][x] + 1;
                        break top;
                    }
                    visited[ny][nx] = true;
                    res[ny][nx] = res[y][x] + 1;
                    q.add(new int[]{ny, nx});
                }
            }
        }
        System.out.println(res[endY][endX]);

    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }

    private static boolean canGo(int y, int x) {
        return inRange(y, x) && grid[y][x] != 1 && !visited[y][x];
    }


}
