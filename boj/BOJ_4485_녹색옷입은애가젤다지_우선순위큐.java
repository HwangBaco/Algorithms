package algorithm.오늘푼문제0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지_우선순위큐 {
    private static int N, ny, nx, y, x;
    private static int[][] map;
    private static int[] start = {0, 0, 0};
    private static final int INF = (int) 1e9;
    private static final int Y = 0;
    private static final int X = 1;
    private static int[] dist;
    private static final int DIST = 2;
    private static Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[DIST]));
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            pq.clear();
            dist = new int[N * N];
            for (int i = 0; i < N * N; i++) {
                dist[i] = INF;
            }

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dist[0] = map[0][0];
            pq.add(start);

            while (!pq.isEmpty()) {
                int[] now = pq.poll();
                y = now[Y];
                x = now[X];

                for (int i = 0; i < 4; i++) {
                    ny = y + dy[i];
                    nx = x + dx[i];
                    if (inRange(ny, nx)) {
                        if (dist[ny * N + nx] > dist[y * N + x] + map[ny][nx]) {
                            dist[ny * N + nx] = dist[y * N + x] + map[ny][nx];
                            pq.add(new int[]{ny, nx, dist[ny * N + nx]});
                        }
                    }
                }
            }
            sb.append(String.format("Problem %d: %d\n", tc++, dist[N * N - 1]));
        }
        System.out.println(sb.toString());
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 & y < N && x >= 0 && x < N;
    }
}
