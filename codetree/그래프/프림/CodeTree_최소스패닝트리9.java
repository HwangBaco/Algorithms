package 알고리즘연습.codetree.그래프.프림;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @algorithm prim (using adjacency list)
 * @time O(E * logV)
 */
public class CodeTree_최소스패닝트리9 {
    private static int[] dist;
    private static boolean[] visited;
    private static ArrayList<Node>[] adj;
    private static int N, M;

    private static class Node {
        int idx, dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = (int) 1e9;
        }

        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }

        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        dist[0] = 0;
        pq.add(new Node(0, 0)); // 시작위치 dist 값은 0으로 설정

        int ans = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int minDist = now.dist;
            int minIdx = now.idx;

            if (visited[minIdx]) {
                continue;
            }
            ans += minDist;
            visited[minIdx] = true;

            for (Node n : adj[minIdx]) {
                int targetIdx = n.idx;
                int targetDist = n.dist;
                if (dist[targetIdx] > targetDist) {
                    dist[targetIdx] = targetDist;
                    pq.add(new Node(targetIdx, targetDist));
                }
            }
        }
        System.out.println(ans);
    }


}
