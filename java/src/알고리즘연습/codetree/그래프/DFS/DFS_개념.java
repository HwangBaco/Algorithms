package 코드트리.그래프.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DFS_개념 {
    public static final int VERTICES_NUM = 7;
    public static final int EDGES_NUM = 6;

    public static List<Integer>[] graph = new ArrayList[VERTICES_NUM +1];
    public static boolean[] visited = new boolean[VERTICES_NUM + 1];

    public static void DFS(int vertex) {
        for (int i = 0; i < graph[vertex].size(); i++) {
            int curV = graph[vertex].get(i);
            if (!visited[curV]) {
                System.out.println(curV);
                visited[curV] = true;
                DFS(curV);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < VERTICES_NUM; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] startPoints = new int[]{1, 1, 1, 2, 4, 6};    // 문제 입력 부분
        int[] endPoints = new int[]{2, 3, 4, 5, 6, 7};      // 문제 입력 부분

        for (int i = 0; i < EDGES_NUM; i++) {
            graph[startPoints[i]].add(endPoints[i]);
            graph[endPoints[i]].add(startPoints[i]);
        }
        int rootVertex = 1;
        System.out.println("rootVertex = " + rootVertex);
        visited[rootVertex] = true;
        DFS(rootVertex);
    }
}
