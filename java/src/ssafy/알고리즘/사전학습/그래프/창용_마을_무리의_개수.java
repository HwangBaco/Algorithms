package ssafy.알고리즘.사전학습.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 창용_마을_무리의_개수 {
    private static boolean[] visited;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            visited = new boolean[n];
            graph = new int[n][n];

            // 인접 리스트 초기화
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                graph[a][b] = b;
                graph[b][a] = a;
            }

            int ans = 0;
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
//                    ans += dfs(j);
                    ans += bfs(j);
                }
            }
            System.out.println("#" + i + " " + ans);


        }

    }

    private static int dfs(int start) {
        for (int v : graph[start]) {
            if (v > 0 && !visited[v]) {
                visited[v] = true;
                dfs(v);
            }
        }
        return 1;
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            Integer now = q.poll();
            for (int v : graph[now]) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
        return 1;
    }
}
