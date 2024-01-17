package 코드트리.그래프.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 갈_수_있는_곳들 {
    private static int n, k;
    private static int ans = 0;
    private static int[][] grid;
    private static int[][] visited;
    private static Queue<Pair> q = new LinkedList<>();

    private static class Pair {
        public int x, y;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static boolean canGo(int y, int x) {
        if (!inRange(y, x) || grid[y][x] == 1 || visited[y][x] == 1) {
            return false;
        }
        return true;
    }

    private static void push(int y, int x) {
        if (canGo(y, x)) {
            visited[y][x] = 1;
            ans++;
            q.add(new Pair(y, x));
        }
    }

    private static void BFS() {
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{1, 0, -1, 0};

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y;
            int x = curr.x;

            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                if (canGo(newY, newX)) {
                    push(newY, newX);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            push(r, c);
            BFS();
        }
        System.out.println(ans);

    }
}
