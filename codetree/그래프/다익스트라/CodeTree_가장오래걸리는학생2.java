package 알고리즘연습.codetree.그래프.다익스트라;

import java.io.*;
import java.util.*;

public class CodeTree_가장오래걸리는학생2 {
    private static int ans;
    private static int N, M;
    private static Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o[1])); // 가중치 기준 내림차순
    private static List<int[]>[] adj;
    private static int[] dist;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[e].add(new int[]{s, w});
        }

        for (int i = 1; i <= N; i++) {
            dist[i] = (int) 1e9;
        }

        dist[N] = 0;
        pq.add(new int[]{N, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int v = now[0];
            int vw = now[1];

            if (dist[v] != vw) {
                continue;
            }

            for (int[] next : adj[v]) {
                int u = next[0];
                int uw = next[1];
                if (dist[u] > dist[v] + uw) {
                    dist[u] = dist[v] + uw;
                    pq.add(new int[]{u, vw + uw});
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            ans = Math.max(dist[i], ans);
        }


        br.close();
        bw.write(sb.append(ans).toString());
        bw.flush();
        bw.close();
    }
}
