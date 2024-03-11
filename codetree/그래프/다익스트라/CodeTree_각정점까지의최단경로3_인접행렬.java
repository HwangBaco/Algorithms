package 알고리즘연습.codetree.그래프.다익스트라;

import java.io.*;
import java.util.StringTokenizer;

public class CodeTree_각정점까지의최단경로3_인접행렬 {
    private static final int MAX_N = 100 + 1;
    private static int ans;
    private static int N, M;
    private static int[][] graph = new int[MAX_N][MAX_N];
    private static boolean[] visited = new boolean[MAX_N];
    private static int[] dist = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프를 인접행렬로 표시
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s][e] = w; // 일방향 그래프
        }

        // 거리 초기화
        for (int i = 1; i <= N; i++) {
            dist[i] = (int) 1e9;
        }

        // 시작 노드의 dist 값을 0으로 설정
        dist[1] = 0;

        // 최소 거리 노드를 기준으로 출발해야 하므로, 매 라운드마다 어디 노드를 기준으로 시작할건지 결정해야 함
        for (int i = 1; i <= N; i++) {
            int minIdx = -1; // 최소 거리 노드
            for (int j = 1; j <= N; j++) {
                if (visited[j]) {
                    continue;
                }
                if (minIdx == -1 || dist[minIdx] > dist[j]) {
                    minIdx = j;
                }
            }
            visited[minIdx] = true;

            // 인접 노드 거리들 -> 최단거리로 갱신 (한 노드에서 그 노드까지)
            for (int j = 1; j <= N; j++) {
                if (graph[minIdx][j] == 0) {
                    continue;
                }
                dist[j] = Math.min(dist[j], dist[minIdx] + graph[minIdx][j]);
            }
        }

        for (int i = 2; i <= N; i++) {
            if (dist[i] == (int) 1e9) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
