package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_최소스패닝트리 {
    private static int N;
    private static int M;
    private static List<Edge> edges;
    private static int[] parent;

    private static class Edge {
        int u,v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int tc = 1; tc <= T; tc++) {
            sb.append(String.format("#%d ", tc));

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];
            edges = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges.add(new Edge(u, v, w));
            }

            edges.sort(Comparator.comparingInt(o -> o.w));

            long ans = 0;
            for (Edge edge : edges) {
                int u = edge.u;
                int v = edge.v;

                if (find(u) == find(v)) {
                    continue;
                }
                ans += edge.w;
                union(u, v);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    private static void union(int u, int v) {
        int uRoot = find(u);
        int vRoot = find(v);
        if (uRoot == vRoot) {
            return;
        }
        if (uRoot < vRoot) {
            parent[vRoot] = uRoot;
        } else {
            parent[uRoot] = vRoot;
        }
    }
}
