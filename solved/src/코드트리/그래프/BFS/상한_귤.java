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
        /*
         * 0, 1, 2로만 이루어진 nxn격자
         * 0 : 벽
         * 1 : 정상 귤
         * 2 : 상한 귤
         *
         * k개의 상한 귤로부터(시작점)
         * 1초에 한번씩 모든 인접한 귤이 상하게 될 때,
         * 각 귤마다 최초로 상하게 되는 시간을 구하는 프로그램을 작성
         *
         * 처음 입력받을 때 상한 귤의 좌표를 starts에 저장
         * 한번에 q에 입력한 뒤
         * bfs 돌려서 dist 배열에 거리 채우기
         *
         * 출력할 때,
         * 1. arr[y][x] == 0 이면 -1출력
         * 2. visited[y][x] == false 이면 -2 출력
         * 3. arr[y][x] == 1 or 2 이면 dist[y][x] 출력
         * */
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
