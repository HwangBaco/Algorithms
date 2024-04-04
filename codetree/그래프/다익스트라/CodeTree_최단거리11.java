package 알고리즘연습.codetree.그래프.다익스트라;

import java.io.*;
import java.util.*;

public class CodeTree_최단거리11 {
    private static int N, M;
    private static int[][] adj;
    private static int[] dist;
    private static boolean[] visited;
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        visited = new boolean[N+1];
        adj = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            dist[i] = (int) 1e9;
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[a][b] = w;
            adj[b][a] = w;
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dist[e] = 0;
        for (int i = 1; i <= N; i++) {
            int minIdx = -1;
            for (int j = 1; j<= N; j++) {
                if (visited[j]) {
                    continue;
                }
                if (minIdx == -1 || dist[j] < dist[minIdx]) {
                    minIdx = j;
                }
            }
            visited[minIdx] = true;

            for (int j = 1; j <= N; j++) {
                if (adj[minIdx][j] == 0) {
                    continue;
                }

                int w = adj[minIdx][j];

                if (dist[j] > dist[minIdx] + w) {
                    dist[j] = dist[minIdx] + w;
                }
            }
        }

        int idx = s;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(s);
        while (idx != e) {
            for (int i = 1; i <= N; i++) {
                if (adj[idx][i] == 0) {
                    continue;
                }
                if (dist[idx] == dist[i] + adj[idx][i]) {
                    dq.add(i);
                    idx = i;
                    break;
                }
            }
        }
        sb.append(dist[s]).append("\n");
        for (int i : dq) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
