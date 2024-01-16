package codetree.그래프.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 각_정점까지의_최단_경로3 {
    public static int[][][] graph;
    public static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1][2];
        distance = new int[n+1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s][e] = new int[]{e, w};
        }
        for (int i = 1; i <= n; i++) {
            distance[i] = (int) 1e9;
        }
        distance[1] = 0;
        dijkstra(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(distance[i] == (int) 1e9 ? -1 : distance[i]);
        }
    }

    public static void dijkstra(int start) {
        Queue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, start));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int dist = p.dist;
            int now = p.node;
            if (distance[now] < dist) {
                continue;
            }
            for (int[] vertex : graph[now]) {
                int next = vertex[0];
                int weight = vertex[1];
                if (distance[next] > dist + weight) {
                    distance[next] = dist + weight;
                    pq.add(new Pair(dist + weight, next));
                }
            }
        }
    }

    public static class Pair implements Comparable<Pair>{
        int dist;
        int node;

        public Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.dist - pair.dist;
        }
    }
}
