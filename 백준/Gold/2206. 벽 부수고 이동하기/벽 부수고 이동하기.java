import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] grid;
    static boolean[][][] visited;
    static int ans = (int) 1e9;
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new char[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        go();
        if (N == 1 && M == 1) {
            System.out.println(1);
        } else {
            System.out.println(ans == (int) 1e9 ? -1 : ans);
        }

    }

    public static void go() {
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0, 1}); // y, x, chance, cnt
        visited[0][0][0] = true;


        top:
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (canGo(ny, nx, now[2])) {
                    if (ny == N-1 && nx == M-1) {
                        ans = Math.min(ans, now[3] + 1);
                        continue top;
                    }
                    q.add(new int[]{ny, nx, now[2], now[3]+1});
                    visited[ny][nx][now[2]] = true;
                } else if (canPass(ny, nx, now[2])) {
                    q.add(new int[]{ny, nx, 1, now[3] + 1});
                    visited[ny][nx][1] = true;
                }
            }
        }
    }
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    public static boolean canGo(int y, int x, int chance) {
        return inRange(y, x) && grid[y][x] == '0' && !visited[y][x][chance];
    }
    public static boolean canPass(int y, int x, int chance) {
        return inRange(y, x) && grid[y][x] == '1' && chance == 0 && !visited[y][x][1];
    }

}