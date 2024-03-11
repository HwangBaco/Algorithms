package 알고리즘연습.codetree.그래프.다익스트라;

import java.io.*;
import java.util.*;

public class CodeTree_각정점까지의최단경로_인접리스트 {
    private static int N, M, K;
    private static int[] dist;
    private static List<int[]>[] adj;
    private static Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1])); 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 인접리스트 입력
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[s].add(new int[]{e, w});
            adj[e].add(new int[]{s, w});
        }
        
        // 거리값 초기화
        for (int i = 1; i <= N; i++) {
            dist[i] = (int) 1e9;
        }
        dist[K] = 0;
        pq.add(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll(); // 거리짧은거
            int v = now[0];
            int vw = now[1];
            for (int[] next : adj[v]) {
                int u = next[0];
                int uw = next[1];
                if (dist[u] > vw + uw) {
                    dist[u] = vw + uw;
                    pq.add(new int[]{u, dist[u]});
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i] == (int) 1e9) {
                sb.append(-1);
            } else {
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
