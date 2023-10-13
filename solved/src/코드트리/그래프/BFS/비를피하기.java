package 코드트리.그래프.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 비를피하기 {
    private static int n, h, m;
    private static int step;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[][] ans;
    private static Queue<Pair> nextPos = new LinkedList<>();
    private static Queue<Pair> startPos = new LinkedList<>();


    private static class Pair {
        private int x;
        private int y;

        private Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static boolean canGo(int y, int x) {
        return inRange(y, x) && arr[y][x] != 1 && !visited[y][x];
    }

    private static void bfs(Pair start) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int startY = start.y;
        int startX = start.x;
        nextPos.add(new Pair(startY, startX));
        visited[startY][startX] = true;

        while (!nextPos.isEmpty()) {
            Pair now = nextPos.poll();
            int nowY = now.y;
            int nowX = now.x;
            for (int i = 0; i < 4; i++) {
                int newY = nowY + dy[i];
                int newX = nowX + dx[i];
                if (canGo(newY, newX)) {
                    if (arr[newY][newX] == 3) {
                        ans[startY][startX] = step + 1;
                        return;
                    } else {
                        visited[newY][newX] = true;
                        nextPos.add(new Pair(newY, newX));
                    }
                }
            }
            step++;
        }
        ans[startY][startX] = -1;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if (num == 2) {
                    startPos.add(new Pair(i, j));
                }
            }
        }

        for (Pair p : startPos) {
            visited = new boolean[n][n];
            step = 0;
            bfs(p);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }
}
