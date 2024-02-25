package 알고리즘연습.codetree.그래프.프림;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Prim Algorithm using adjacency matrix
 *
 * @time O(V^2)
 */
public class CodeTree_최소스패닝트리8 {
    private static int n, m;
    private static int[][] adj;
    private static boolean[] visited;
    private static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // n, m 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        // 인접 행렬 구성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u][v] = adj[u][v] == 0 ? w : Math.min(adj[u][v], w);
            adj[v][u] = adj[v][u] == 0 ? w : Math.min(adj[v][u], w);
        }

        for (int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9;
        }

        dist[1] = 0; // 아무 노드를 잡고 시작 노드로 설정

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int minIdx = -1;
            // n개의 정점 중
            // 아직 방문하지 않은 정점 중에서
            // dist값이 가장 작은 정점을 찾아줌.
            for (int j = 1; j <= n; j++) {
                if (visited[j]) {
                    continue;
                }
                if (minIdx == -1 || dist[minIdx] > dist[j]) {
                    minIdx = j;
                }
            }
            visited[minIdx] = true;
            ans += dist[minIdx];

            for (int j = 1; j <= n; j++) {
                if (adj[minIdx][j] == 0) {
                    continue;
                }
                dist[j] = Math.min(dist[j], adj[minIdx][j]);
            }
        }

        System.out.println(ans);
    }
}
