package 알고리즘연습.codetree.그래프.크루스칼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class CodeTree_최소스패닝트리 {
    private static int N, M;
    private static List<Edge> edges = new ArrayList<>();
    private static int[] parent;
    private static int ans;
    private static class Edge {
        private int u; // 왼쪽 정점
        private int v; // 오른쪽 정점
        private int w; // 가중치

        private Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        parent = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
            parent[u] = u;
            parent[v] = v;
        }
        edges.sort(Comparator.comparingInt(e -> e.w)); // 가중치 기준 오름차순 정렬

        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;

            if (find(v) == find(u)) {
                continue;
            }
            union(u, v);
            ans += edge.w;
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
        if (uRoot < vRoot) {
            parent[vRoot] = uRoot;
        } else {
            parent[uRoot] = vRoot;
        }
    }
}
