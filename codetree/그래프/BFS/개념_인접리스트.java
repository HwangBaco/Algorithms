package 코드트리.그래프.BFS;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class 개념_인접리스트 {
    private static final int VERTICES_NUM = 7;
    private static final int EDGES_NUM = 6;
    private static int[][] graph = new int[VERTICES_NUM+1][VERTICES_NUM+1];
    private static boolean[] visited = new boolean[VERTICES_NUM+1];
    private static Queue<Integer> q = new LinkedList<>();
    private static void BFS() {
        while (!q.isEmpty()) {
            int currV = q.poll();

            for (int nextV = 1; nextV < VERTICES_NUM; nextV++) {
                if (graph[currV][nextV] == 1 && !visited[nextV]) {
                    System.out.println(nextV);
                    visited[nextV] = true;
                    q.add(nextV);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        int[] startPoints = new int[]{1, 1, 1, 2, 4, 6};
        int[] endPoints = new int[]{2, 3, 4, 5, 6, 7};

        for (int i = 0; i < EDGES_NUM; i++) {
            int start = startPoints[i];
            int end = endPoints[i];

            graph[start][end] = 1;
            graph[end][start] = 1;
        }
        int rootVertex = 1;
        System.out.println(rootVertex);
        visited[rootVertex] = true;
        q.add(rootVertex);
        BFS();
    }

}
