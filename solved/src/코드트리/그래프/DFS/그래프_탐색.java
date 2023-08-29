package 코드트리.그래프.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 그래프_탐색 {
    public static int VERTICES_NUM;
    public static int EDGES_NUM;
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        VERTICES_NUM = Integer.parseInt(st.nextToken());
        EDGES_NUM = Integer.parseInt(st.nextToken());
        graph = new ArrayList[VERTICES_NUM + 1];
        visited = new boolean[VERTICES_NUM + 1];
        for (int i = 0; i <= VERTICES_NUM; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < EDGES_NUM; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        visited[1] = true;
        DFS(1);
        System.out.println(ans);
    }

    public static void DFS(int curV) {
        for (int i : graph[curV])
            if (!visited[i]) {
                visited[i] = true;
                ans++;
                DFS(i);
            }
    }
}

