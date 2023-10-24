package 코드트리.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static Queue<Pair> q = new LinkedList<>();
    private static Queue<Integer> pq = new PriorityQueue<>();
    private static int ans = 0;
    public static void main(String[] args) throws IOException {
        /*
        * 마을의 크기가 3일 때만 ans를 올려야 하는데, 그걸 못함
        * BFS로 했어야 했나...
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    q.add(new Pair(i, j));
                }
                arr[i][j] = num;
            }
        }
        for (Pair p : q) {
            visited[p.y][p.x] = true;
            dfs(p.y, p.x, 1);

        }
        System.out.println(-pq.poll());

    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static boolean canGo(int y, int x) {
        return inRange(y, x) && arr[y][x] == 1 && !visited[y][x];
    }

    private static void dfs(int y, int x, int size) {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (canGo(newY, newX)) {
                size++;
                visited[newY][newX] = true;
                dfs(newY, newX, size);
            }
        }

        pq.add(-size);
    }

    private static class Pair {
        private int x, y;

        private Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
