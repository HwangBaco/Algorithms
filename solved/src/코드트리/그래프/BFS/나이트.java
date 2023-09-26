package 코드트리.그래프.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트 {
    private static int n;
    private static int[] dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dy = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    private static int x1, y1, x2, y2;
    private static int[][] arr;
    private static Queue<Pair> q = new LinkedList<>();
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new int[n][n];
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = -1;
            }
        }

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken())-1;
        y1 = Integer.parseInt(st.nextToken())-1;
        x2 = Integer.parseInt(st.nextToken())-1;
        y2 = Integer.parseInt(st.nextToken())-1;

        BFS();
        System.out.println(arr[y2][x2]);

    }

    private static void BFS() {
        q.add(new Pair(x1, y1));
        arr[y1][x1] = 0;
        visited[y1][x1] = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int curX = p.getX();
            int curY = p.getY();

            for (int i = 0; i < 8; i++) {
                int newY = curY + dy[i];
                int newX = curX + dx[i];
                if (inRange(newX, newY) && visited[newY][newX] == 0) {
                    q.add(new Pair(newX, newY));
                    visited[newY][newX] = 1;
                    arr[newY][newX] = arr[curY][curX] + 1;
                }
            }
        }
    }

    private static class Pair {
        private int x;
        private int y;

        public int getX() {
            return this.x;
        }
        public int getY() {
            return this.y;
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

}
