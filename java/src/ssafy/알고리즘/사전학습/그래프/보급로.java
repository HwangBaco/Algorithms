package ssafy.알고리즘.사전학습.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class 보급로 {
    /*
    * 알고리즘 : 다익스트라
    * */
    private static int[][] distances;
    private static int[][] weights;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine());
            weights = new int[n][n];
            distances = new int[n][n];
            for (int j = 0; j < n; j++) {
                String s = br.readLine();
                for (int k = 0; k < n; k++) {
                    weights[j][k] = Integer.parseInt(s.substring(k, k + 1));
                    distances[j][k] = Integer.MAX_VALUE;
                }
            }
            Pair start = new Pair(0, new int[]{0, 0});
            distances[0][0] = 0;
            dijkstra(start);
            System.out.println("#" + i + " " + distances[n - 1][n - 1]);
        }
    }

    private static void dijkstra(Pair start) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        Queue<Pair> pq = new PriorityQueue();
        pq.add(start);

        while (!pq.isEmpty()) {
            Pair crt = pq.poll();
            int dist = crt.dist;
            int[] now = crt.node;

            if (distances[now[0]][now[1]] < dist) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newY = now[0] + dy[i];
                int newX = now[1] + dx[i];
                if (inRange(newY, newX)){
                    if (distances[newY][newX] > dist + weights[newY][newX]) {
                        int cost = dist + weights[newY][newX];
                        distances[newY][newX] = cost;
                        pq.add(new Pair(cost, new int[]{newY, newX}));
                    }
                }
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static class Pair implements Comparable<Pair> {
        private int dist;
        private int[] node;

        private Pair(int dist, int[] node) {
            this.dist = dist;
            this.node = node;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.dist == o.dist) {
                if (this.node[0] == o.node[0]) {
                    return this.node[1] - o.node[1];
                }
                return this.node[0] - o.node[0];
            }
            return this.dist - o.dist;
        }
    }
}
