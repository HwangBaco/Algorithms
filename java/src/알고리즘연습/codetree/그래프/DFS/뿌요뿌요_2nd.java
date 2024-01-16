package 코드트리.그래프.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뿌요뿌요_2nd {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[][] dist;
    private static Queue<Integer> pq = new PriorityQueue<>();
    private static int depth = 1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int boomCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                pq.add(-1);
                dfs(new Pair(i, j));
                if (depth >= 4) {
                    boomCnt++;
                }
                depth = 1;
            }
        }
        System.out.println(boomCnt + " " + -pq.poll());
    }
    private static void dfs(Pair crt) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int newY = crt.y + dy[i];
            int newX = crt.x + dx[i];
            if (canGo(newY, newX, arr[crt.y][crt.x])) {
                visited[newY][newX] = true;
                dist[newY][newX] = dist[crt.y][crt.x] + 1;
                depth++;
                dfs(new Pair(newY, newX));
                pq.add(-depth);
            }
        }
    }

    private static class Pair {
        private int x, y;

        private Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static boolean canGo(int y, int x, int num) {
        return inRange(y,x) && arr[y][x] == num && !visited[y][x];
    }
}
