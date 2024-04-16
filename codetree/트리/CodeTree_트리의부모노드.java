package 알고리즘연습.codetree.트리;

import java.util.*;
import java.io.*;

public class CodeTree_트리의부모노드 {
    private static int[] parent;
    private static boolean[] visited;
    private static List<Integer>[] edges;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        edges = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        visited[1] = true;
        go(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }


    }
    private static void go(int v) {
        for (int i = 0; i < edges[v].size(); i++) {
            int u = edges[v].get(i);
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            parent[u] = v;
            go(u);
        }
    }
}
