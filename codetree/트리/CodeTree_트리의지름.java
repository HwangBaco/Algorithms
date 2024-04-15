package 알고리즘연습.codetree.트리;
import java.util.*;
import java.io.*;
public class CodeTree_트리의지름 {
    private static List<int[]>[] edges;
    private static boolean[] visited;
    private static int treeDepth;
    private static int root;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b, c});
            edges[b].add(new int[]{a, c});
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        go(1, 0);
        visited = new boolean[n + 1];
        visited[root] = true;
        go(root, 0);

        System.out.println(treeDepth);

    }

    private static void go(int v, int depth) {
        if (depth > treeDepth) {
            treeDepth = depth;
            root = v;
        }
        for (int[] u : edges[v]) {
            int node = u[0];
            int dist = u[1];
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            go(node, depth + dist);
        }
    }
}
