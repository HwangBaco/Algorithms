package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1197_최소스패닝트리 {
    private static List<int[]>[] adj;
    private static int[] dist;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int V = Integer.parseInt(st.nextToken());
        adj = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        final int E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[v].add(new int[]{u, w});
            adj[u].add(new int[]{v, w});
        }

        dist[1] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); // 가중치 기준 오름차순
        pq.add(new int[]{1, 0});

        int ans = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            int v = now[0];

            if (visited[v]) {
                continue;
            }

            ans += now[1];
            visited[v] = true;


            for (int[] next : adj[v]) {
                int u = next[0];
                int w = next[1];
                if (dist[u] > w) {
                    dist[u] = w;
                    pq.add(next);
                }
            }
        }
        System.out.println(ans);

    }
}
