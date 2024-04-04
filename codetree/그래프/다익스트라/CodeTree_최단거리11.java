package 알고리즘연습.codetree.그래프.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CodeTree_최단거리11 {
    private static int N, M, S, E;
    private static List<int[]>[] adj;
    public static final int V = 0;
    public static final int W = 1;
    public static final int INF = (int) 1e9;
    private static int[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>(N+1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{b, w});
            adj[b].add(new int[]{a, w});
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[W]));
        dist[S] = 0;
        pq.add(new int[]{S, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowv = now[0];
            int noww = now[1];

            if (noww != dist[nowv]) {
                continue;
            }

            for (int[] a : adj[nowv]) {
                int v = a[V];
                int w = a[W];
                if (dist[v] > dist[nowv] + w) {
                    dist[v] = dist[nowv] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        System.out.println(dist[E]);
    }
}
