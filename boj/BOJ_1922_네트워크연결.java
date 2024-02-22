package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결 {
    private static int N, M;
    private static List<Edge> edges = new ArrayList<>();
    private static int[] parent;
    private static class Edge {
        int u, v, w;

        private Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            parent[v] = v;
            parent[u] = u;
            edges.add(new Edge(u, v, w));
        }

        edges.sort(Comparator.comparingInt(e -> e.w));

        int ans = 0;
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;

            if (find(u) == find(v)) {
                continue;
            }
            ans += edge.w;
            union(u, v); // 방문 처리와도 같은 역할
        }

        System.out.println(ans);

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
        if (vRoot < uRoot) {
            parent[uRoot] = vRoot;
        } else {
            parent[vRoot] = uRoot;
        }
    }
}
