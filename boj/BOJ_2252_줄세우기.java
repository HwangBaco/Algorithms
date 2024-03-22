package 알고리즘연습.boj;

import java.io.*;
import java.util.*;

public class BOJ_2252_줄세우기 {
    private static int N, M;
    private static ArrayList<Integer>[] adj;
    private static int[] inDegree;
    private static ArrayDeque<Integer> q = new ArrayDeque<>();
    private static ArrayDeque<Integer> ans = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inDegree = new int[N+1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[b].add(a);
            inDegree[a]++;
        }

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int v = q.poll();
            ans.addLast(v);
            for (int u : adj[v]) {
                inDegree[u]--;
                if (inDegree[u] == 0) {
                    q.add(u);
                }
            }
        }
        while (!ans.isEmpty()) {
            sb.append(ans.pollLast()+" ");
        }
        System.out.println(sb.toString());
    }
}
