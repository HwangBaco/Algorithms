package codetree.그래프.다익스트라;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 각_정점까지의_최단_경로 {
    static int n, m;

    static int[] distance;

    static List<Node>[] graph;
    public static void main(String[] args) throws IOException {
        /*
         * 정점 n개와 간선 m개로 구성된 무방향 그래프가 주어집니다.
         * k번 정점에서 다른 모든 정점으로 가는 최단 경로 = 다익스트라
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        distance = new int[n+1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            distance[i] = (int) 1e7;
        }
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 무방향이니까 양방향
            graph[s].add(new Node(w, e));
            graph[e].add(new Node(w, s));
        }
        distance[start] = 0;

        dijkstra(start);

        // 우선순위 큐는 큐의 역할에 지나지 않음
        // 다음 어디를 갈지만 나오면 됨.

        for (int i = 1; i <= n; i++) {
            System.out.println(distance[i] == (int) 1e9 ? -1 : distance[i]);
        }
    }
    static void dijkstra(int start) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, start));

        while (!pq.isEmpty()) {
            Node p = pq.poll();
            int dist = p.weight;
            int now = p.node;

            if (distance[now] < dist) {
                continue;
            }

            for (Node node : graph[now]) {
                int weight = node.weight;
                int next = node.node;

                if (distance[next] > weight + dist) {
                    distance[next] = weight + dist;
                    pq.add(new Node(distance[next], next));
                }


            }

        }

    }

    static class Node implements Comparable<Node>{
        int weight;
        int node;

        Node(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

}
