package 알고리즘연습.codetree.그래프.플로이드워셜;

import java.io.*;
import java.util.*;

public class CodeTree_각정점까지의최단경로2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, w);
        }

        int[][] ans = solution(n, m, edges);

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static int[][] solution(int n, int m, Edge[] edges) {
        // 인접행렬(거리) 구성하고 INF로 초기화
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    dist[i][j] = (int) 1e9;
                } else {
                    dist[i][j] = 0;
                }
            }
        }

        // 인접리스트 정보로 dist 행렬 업데이트
        for (Edge e : edges) {
            int a = e.a;
            int b = e.b;
            int w = e.w;
            dist[a][b] = Math.min(dist[a][b], w);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = dist[i][j] == (int) 1e9 ? -1 : dist[i][j];
            }
        }

        return dist;
    }

    private static class Edge {
        int a, b, w;

        private Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
}
