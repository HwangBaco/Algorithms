package algorithm.오늘푼문제0402;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지_인접행렬 {
    private static int[][] map;
    private static boolean[] visited;
    private static int[] dist;
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dx = {0, 0, 1, -1};
    private static int N, ans, totalNodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 상하좌우로는 반드시 갈수있고,
        // 간 곳은 갈 필요 없고
        long TC = 0;

        while (true) {
            N = Integer.parseInt(br.readLine());
            TC++;
            if (N == 0) {
                break;
            }
            totalNodes = N * N;
            map = new int[N][N];
            visited = new boolean[totalNodes];
            dist = new int[totalNodes];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < totalNodes; i++) {
                dist[i] = (int) 1e9;
            }

            dist[0] = map[0][0]; // start node

            top:
            for (int i = 0; i < totalNodes; i++) {
                // 아직 방문하지 않은 노드 중에서 최단거리 노드 찾기
                int minIdx = -1;
                for (int j = 0; j < totalNodes; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    if (minIdx == -1 || dist[j] < dist[minIdx]) {
                        minIdx = j; // 최단거리 노드 찾기
                    }
                }
                visited[minIdx] = true;

                // 최단거리 노드가 나왔으니 그 노드의 인접 노드를 탐색하며 출발지로부터 거리 갱신
                int y = minIdx / N;
                int x = minIdx % N;
                for (int j = 0; j < 4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if (inRange(ny, nx)) {
                        int w = map[ny][nx];
                        dist[ny * N + nx] = Math.min(dist[ny * N + nx], dist[minIdx] + w);
                        if (ny == N - 1 && nx == N - 1) { // 도착 지점이라면
                            ans = dist[ny * N + nx];
                            break top;
                        }
                    }
                }
            }
            sb.append(String.format("Problem %d: %d\n", TC, ans));
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 & y < N && x >= 0 && x < N;
    }
}
