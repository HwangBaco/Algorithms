package 알고리즘연습.codetree.그래프.프림;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
    private static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private static class Node {
        int idx, dist;

        private Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    private static final int INT_MAX = Integer.MAX_VALUE;
    private static final int n = 5, m = 7;
    private static ArrayList<Node>[] adj = new ArrayList[n + 1];
    private static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

    private static int[] dist = new int[n+1];
    private static boolean[] visited = new boolean[n + 1];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 간선 리스트
        Edge[] edges = new Edge[]{
                new Edge(-1, -1, -1),
                new Edge(2, 1, 2),
                new Edge(1, 4, 3),
                new Edge(4, 2, 1),
                new Edge(5, 2, 4),
                new Edge(5, 4, 2),
                new Edge(4, 3, 2),
                new Edge(1, 3, 6)
        };


    }
}
