package 코드트리.그래프.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상한_귤 {
    private static class Pair {
        private int x, y;

        private Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    private static int n, k;
    private static Queue<Pair> q = new LinkedList<>();
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[][] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
                arr[i][j] = num;
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    System.out.print(-1 + " ");
                } else if (!visited[i][j]) {
                    System.out.print(-2 + " ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }


    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static boolean canGo(int y, int x) {
        return inRange(y, x) && arr[y][x] != 0 && !visited[y][x];
    }

    private static void bfs() {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        while (!q.isEmpty()) {
            Pair crt = q.poll();
            int crtX = crt.x;
            int crtY = crt.y;
            for (int i = 0; i < 4; i++) {
                int newY = crtY + dy[i];
                int newX = crtX + dx[i];
                if (canGo(newY, newX)) {
                    visited[newY][newX] = true;
                    dist[newY][newX] = dist[crtY][crtX] + 1;
                    q.add(new Pair(newY, newX));
                }
            }
        }
    }
}
