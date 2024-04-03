package 알고리즘연습.swea.알고리즘수업;

import java.io.*;
import java.util.*;
public class SWEA_벽돌깨기 {
    private static int N, W, H, ans, res, y, x, r, ny, nx;
    private static int[][] map;
    private static int[] now;
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            ans = (int) 1e9;
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j] = num;
                }
            }

            go(map, 0);
            sb.append(String.format("#%d %d\n", tc, ans));
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void go(int[][] map, int depth) {
        getLeft(map);
        if (res == 0 || depth == N) {
            ans = Math.min(ans, res);
            return;
        }
        for (int j = 0; j < W; j++) {
            int[][] copyMap = copyMap(map);
            int sy = -1, sx = j;
            for (int i = 0; i < H; i++) {
                if (copyMap[i][j] > 0) {
                    sy = i;
                    break;
                }
            }
            if (sy == -1) {
                continue;
            }

            // sy, sx 정해진 순간.
            int target = copyMap[sy][sx];
            bomb(copyMap, sy, sx);
            if (target > 1) {
                gravity(copyMap);
            }

            go(copyMap, depth + 1);
        }
    }

    private static void getLeft(int[][] map) {
        res = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] > 0) {
                    res++;
                }
            }
        }
    }

    private static void print(int[][] copyMap) {
        System.out.println("-------------");
        for (int i = 0; i < H; i++) {
            for (int k = 0; k < W; k++) {
                System.out.print(copyMap[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] temp = new int[H][W];
        for (int i = 0; i < H; i++) {
            temp[i] = map[i].clone();
        }
        return temp;
    }

    private static void bomb(int[][] map, int sy, int sx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sy, sx, map[sy][sx] - 1});
        map[sy][sx] = -1;

        while (!q.isEmpty()) {
            now = q.poll();
            y = now[0];
            x = now[1];
            r = now[2]; // range
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= r; j++) {
                    ny = y + dy[i] * j;
                    nx = x + dx[i] * j;
                    if (inRange(ny, nx) && map[ny][nx] > 0) {
                        if (map[ny][nx] > 1) {
                            q.add(new int[]{ny, nx, map[ny][nx] - 1});
                        }
                        map[ny][nx] = -1;
                    }
                }
            }
        }
    }

    private static void gravity(int[][] map) {
        for (int j = 0; j < W; j++) {
            int[] g = new int[H];
            int idx = H-1;
            for (int i = H-1; i >= 0; i--) {
                if (map[i][j] > 0) {
                    g[idx--] = map[i][j];
                }
            }
            for (int i = 0; i < H; i++) {
                map[i][j] = g[i];
            }
        }
    }
}
