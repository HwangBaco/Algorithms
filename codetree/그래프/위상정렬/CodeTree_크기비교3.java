package 알고리즘연습.codetree.그래프.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @algorithm topological sort (using priority queue)
 * @time O(V * logV + E)
 */
public class CodeTree_크기비교3 {
    private static int N, M;
    private static int[] inDegree;
    private static ArrayList<Integer>[] adj;
    private static Queue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N];
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            adj[from].add(to);
            inDegree[to]++;
        }

        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            Integer now = pq.poll();

            // business logic part
            System.out.print(now+1 + " ");

            for (int node : adj[now]) {
                inDegree[node]--;

                if (inDegree[node] == 0) {
                    pq.add(node);
                }
            }
        }
    }
}
