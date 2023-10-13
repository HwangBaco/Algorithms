package 코드트리.그래프.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 비를피하기_해설보고푼거 {
    /*
    * 도저히 틀린점을 모르겠어서 일단 해설보고 내 방식대로 고쳐서 공부함.
    * 다시 나중에 혼자 풀어보자...
    * */
    private static int n, h, m;
    private static int[][] arr;
    private static boolean[][] visited;
    private static Queue<Pair> q = new LinkedList<>();
    private static Queue<Pair> shelters = new LinkedList<>();
    private static int[][] steps;

    private static class Pair {
        private int x, y;

        private Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        steps = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 3) {
                    shelters.add(new Pair(i, j));
                }
                arr[i][j] = num;
            }
        }

        for (Pair shelter : shelters) {
            q.add(shelter);
            visited[shelter.y][shelter.x] = true;
            steps[shelter.y][shelter.x] = 0;
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 2) {
                    System.out.print(0 + " ");
                } else {
                    if (!visited[i][j]) {
                        System.out.print(-1 + " ");
                    } else {
                        System.out.print(steps[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static boolean canGo(int y, int x) {
        return inRange(y, x) && arr[y][x] != 1 && !visited[y][x];
    }

    private static void bfs() {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        while (!q.isEmpty()) {
            Pair now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            for (int i = 0; i < 4; i++) {
                int newY = nowY + dy[i];
                int newX = nowX + dx[i];
                if (canGo(newY, newX)) {
                    steps[newY][newX] = steps[nowY][nowX] + 1;
                    visited[newY][newX] = true;
                    q.add(new Pair(newY, newX));
                }
            }
        }
    }
}
