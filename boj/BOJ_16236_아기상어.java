package 알고리즘연습.boj;

import java.io.*;
import java.util.*;

/**
 * @intuition 완탐으로 가능할 듯 하다
 * @algorithm
 * @time O(N^4)
 * @memory O(N^2)
 */
public class BOJ_16236_아기상어 {
    private static int N, ans, cnt, sharkSize, sharkY, sharkX;
    private static int[][] map;
    private static boolean hasTarget;
    private static int[] dy = {-1, 0, 0, 1};
    private static int[] dx = {0, -1, 1, 0};
    private static int[] visited;
    private static int[][] step;
    private static Queue<int[]> q = new PriorityQueue<>(((o1, o2) -> {
        if (o1[2] == o2[2]) {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }
        return o1[2] - o2[2];
    }));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        step = new int[N][N];

        int num;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                num = Integer.parseInt(st.nextToken());
                if (num == 9) {
                    sharkY = i;
                    sharkX = j;
                    continue;
                }
                map[i][j] = num;
            }
        }

        sharkSize = 2;

        do {
            hasTarget = bfs();
        } while (hasTarget);

        br.close();
        bw.write(sb.append(ans).toString());
        bw.flush();
        bw.close();
    }
    private static boolean bfs() {
        q.clear();
        q.add(new int[]{sharkY, sharkX, step[sharkY][sharkX]});
        visited = new int[N];
        visited[sharkY] |= 1 << sharkX;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];

            if (map[y][x] != 0 && map[y][x] < sharkSize) { // 잡아먹을 수 있는 경우
                cnt++;
                if (cnt == sharkSize) {
                    sharkSize++;
                    cnt = 0;
                }

                map[y][x] = 0;
                ans = step[y][x];
                sharkY = y;
                sharkX = x;
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (canGo(ny, nx)) {
                    step[ny][nx] = step[y][x] + 1;
                    visited[ny] |= 1 << nx;

                    q.add(new int[]{ny, nx, step[ny][nx]});
                }
            }
        }
        return false;
    }

    private static boolean canGo(int y, int x) {
        return inRange(y, x) && map[y][x] <= sharkSize && (visited[y] & (1 << x)) == 0;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}
