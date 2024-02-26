package 알고리즘연습.codetree.그래프.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CodeTree_친구의키 {
    private static int[] inDegree;
    private static ArrayList<Integer>[] adj;
    private static Queue<Integer> q = new ArrayDeque<>();
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        inDegree = new int[N];

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 인접리스트 init + in-degree 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            inDegree[b]++;
        }

        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            Integer now = q.poll();

            // business part
            System.out.print(now+1 + " ");

            for (int node : adj[now]) {
                inDegree[node]--;

                if (inDegree[node] == 0) {
                    q.add(node);
                }
            }
        }
    }
}
