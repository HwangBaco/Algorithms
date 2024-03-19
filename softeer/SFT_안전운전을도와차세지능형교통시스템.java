package 알고리즘연습.softeer;

import java.io.*;
import java.util.*;

public class SFT_안전운전을도와차세지능형교통시스템 {
    private static int N, T, ans;
    private static int[][][] arr;
    private static List<int[]>[] delta;
    private static boolean[][] visited;
    private static final int DOWN = 3;
    private static final int RIGHT = 0;
    private static final int UP = 1;
    private static final int LEFT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N][N][4];
        delta = new ArrayList[12];
        visited = new boolean[N][N];

        for (int i = 0; i < 12; i++) {
            delta[i] = new ArrayList<>();
        }

        delta[0].add(new int[]{-1, 0});
        delta[0].add(new int[]{0, 1});
        delta[0].add(new int[]{1, 0});
        delta[1].add(new int[]{0, -1});
        delta[1].add(new int[]{-1, 0});
        delta[1].add(new int[]{0, 1});
        delta[2].add(new int[]{-1, 0});
        delta[2].add(new int[]{0, -1});
        delta[2].add(new int[]{1, 0});
        delta[3].add(new int[]{0, -1});
        delta[3].add(new int[]{1, 0});
        delta[3].add(new int[]{0, 1});
        delta[4].add(new int[]{-1, 0});
        delta[4].add(new int[]{0, 1});
        delta[8].add(new int[]{0, 1});
        delta[8].add(new int[]{1, 0});
        delta[5].add(new int[]{0, -1});
        delta[5].add(new int[]{-1, 0});
        delta[9].add(new int[]{-1, 0});
        delta[9].add(new int[]{0, 1});
        delta[6].add(new int[]{1, 0});
        delta[6].add(new int[]{0, -1});
        delta[10].add(new int[]{0, -1});
        delta[10].add(new int[]{-1, 0});
        delta[7].add(new int[]{0, 1});
        delta[7].add(new int[]{1, 0});
        delta[11].add(new int[]{1, 0});
        delta[11].add(new int[]{0, -1});



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                arr[i][j][0] = Integer.parseInt(st.nextToken()) - 1;
                arr[i][j][1] = Integer.parseInt(st.nextToken()) - 1;
                arr[i][j][2] = Integer.parseInt(st.nextToken()) - 1;
                arr[i][j][3] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        bfs();

        br.close();
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1}); // 우 상 좌 하
        visited[0][0] = true;
        ans = 1;
        int[][] time = new int[N][N];
        time[0][0] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            if (time[y][x] == T) {
                return;
            }
            int nowDir = now[2];
            int light = arr[y][x][time[y][x] % 4];

            for (int[] d : delta[light]) {
                int ny = y + d[0];
                int nx = x + d[1];

                if (canGo(ny, nx, nowDir, light)) {
                    if (!visited[ny][nx]) {
                        ans++;
                        visited[ny][nx] = true;
                    }
                    time[ny][nx] = time[y][x] + 1;
                    q.add(new int[]{ny, nx, getDir(d[0], d[1], light % 4)});
                }
            }
        }
    }

    private static int getDir(int dy, int dx, int dir) {
        if (dir == DOWN) { // 아래로 이동하면서
            if (dx < 0) {
                return LEFT;
            } else if (dx == 0) {
                return DOWN;
            } else if (dx > 0) {
                return RIGHT;
            }
        } else if (dir == RIGHT) {
            if (dy < 0) {
                return UP;
            } else if (dy == 0) {
                return RIGHT;
            } else if (dy > 0) {
                return DOWN;
            }
        } else if (dir == UP) {
            if (dx < 0) {
                return LEFT;
            } else if (dx == 0) {
                return UP;
            } else if (dx > 0) {
                return RIGHT;
            }
        } else if (dir == LEFT) {
            if (dy < 0) {
                return UP;
            } else if (dy == 0) {
                return LEFT;
            } else if (dy > 0) {
                return DOWN;
            }
        }
        return -1;
    }

    private static boolean canGo(int y, int x, int nowDir, int lightDir) {
        return inRange(y, x) && (nowDir == lightDir % 4);
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}
