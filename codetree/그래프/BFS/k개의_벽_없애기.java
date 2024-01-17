package 알고리즘연습.codetree.그래프.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class k개의_벽_없애기 {
    private static Queue<Pair> q = new LinkedList<>();
    private static int[][] arr;
    private static int[][] ans;
    private static boolean[][] visited;
    private static boolean[][] selected;

    private static int r1,c1,r2,c2;

    private static List<Pair> li = new ArrayList<>();

    private static Queue<Integer> pq = new PriorityQueue<>(); // 최단거리 산출
    private static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        /*
        * 입력받을 때, 1인 좌표를 li에 저장해두고
        * 나중에 s
        * */

        arr = new int[n][n];
        ans = new int[n][n];
        selected = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    li.add(new Pair(i, j));
                }
                arr[i][j] = num;
            }
        }
        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken()) - 1;
        c1 = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken()) - 1;
        c2 = Integer.parseInt(st.nextToken()) - 1;



        go(0);

        if (pq.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(pq.poll());
        }

    }
    private static void bfs() {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                if (canGo(newY, newX)) {
                    visited[newY][newX] = true;
                    ans[newY][newX] = ans[y][x] + 1;
                    q.add(new Pair(newY, newX));
                }
            }

        }

    }

    private static void go(int cnt) {
        if (cnt == k) {
            ans = new int[n][n];
            visited = new boolean[n][n];
            q.add(new Pair(r1, c1));
            visited[r1][c1] = true;
            bfs();
            if (ans[r2][c2] > 0) {
                pq.add(ans[r2][c2]);
            }
            return;
        }
        for (Pair pair : li) {
            int x = pair.x;
            int y = pair.y;
            if (!selected[y][x]) {
                arr[y][x] = 0;
                selected[y][x] = true;
                cnt++;

                go(cnt);

                arr[y][x] = 1;
                selected[y][x] = false;
                cnt--;
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static boolean canGo(int y, int x) {
        return inRange(y, x) && arr[y][x] == 0 && !visited[y][x];
    }

    private static class Pair {
        private int x, y;

        private Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
