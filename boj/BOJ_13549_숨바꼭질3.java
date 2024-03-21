package 알고리즘연습.boj;

import java.util.*;
import java.io.*;

/**
 * @intuition
 * 처음에는 DP라고 생각했는데, 아니였다. DP가 성립될 수 있는 조건에 대하여 다시금 돌아보게 됐다.
 * 이 문제는 목적지까지 최단 거리를 계속 갱신해서 가는 다익스트라 문제이다.
 *
 * @algorithm dijkstra
 * @time O(E * logV) ; 연결된 간선 개수만큼 pq를 이용하여 순회하는 다익스트라 -> 296 ms
 * @memory O(V * E) ; 노드당 엣지 개수 저장하는 list 배열 운영 -> 40744 KB
 */
public class BOJ_13549_숨바꼭질3 {
    public static final int MAX = 100000;
    private static int[] dist = new int[MAX + 1];
    private static List<int[]>[] adjs = new ArrayList[MAX + 1];
    private static Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
    private static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // start
        K = Integer.parseInt(st.nextToken()); // end

        for (int i = 0; i <= MAX; i++) {
            dist[i] = (int) 1e9; // INF
            adjs[i] = new ArrayList<>();
        }

        dist[N] = 0;

        pq.add(new int[]{N, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int v = now[0];
            int w = now[1];

            if (v == K) {
                break;
            }

            if (v + 1 <= MAX) {
                adjs[v].add(new int[]{v + 1, 1});
            }
            if (v - 1 >= 0) {
                adjs[v].add(new int[]{v - 1, 1});
            }
            if (v << 1 <= MAX) {
                adjs[v].add(new int[]{v << 1, 0});
            }

            for (int[] adj : adjs[v]) {
                int nv = adj[0];
                int nw = adj[1];

                if (dist[nv] > dist[v] + nw) {
                    dist[nv] = dist[v] + nw;
                    pq.add(new int[]{nv, dist[nv]});
                }
            }
        }

        System.out.println(dist[K]); // answer
    }
}
