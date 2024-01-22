package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17142_연구소3 {
    static int n, m;
    static List<int[]> viruses;
    static boolean[][] visited;
    static List<int[]> li;
    static int ans = 0;
    static boolean flag;
    static int[][] arr;
    static Queue<int[]> q;
    static int[][] time;
    static final int Y = 0;
    static final int X = 1;
    static boolean[][] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        time = new int[n][n];
        selected = new boolean[n][n];
        q = new LinkedList<>();
        li = new ArrayList<>();
        visited = new boolean[n][n];
        viruses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }
        go();
        System.out.println(ans);
    }

    static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    static boolean canGo(int y, int x) {
        return inRange(y, x) && arr[y][x] != 1 && !visited[y][x];
    }

    static void go() {
        if (li.size() == m) {
            q.addAll(li);
            bfs();
            return;
        }
        for (int[] virus : viruses) {
            int y = virus[Y];
            int x = virus[X];
            if (!selected[y][x]) {
                selected[y][x] = true;
                li.add(new int[]{y, x});
                visited[y][x] = true;
                go();
                selected[y][x] = false;
                li.remove(li.size() - 1);
                visited[y][x] = false;
            }
        }
    }
    static void bfs() {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[Y];
            int x = now[X];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (canGo(ny, nx)) {
                    if (arr[ny][nx] == 2) {
                        time[ny][nx] = 0;
                    } else {
                        time[ny][nx] = time[y][x] + 1;
                    }
                    q.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, time[i][j]);
                if (time[i][j] == 0) {
                    flag = true;
                    res = -1;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        ans = Math.min(ans, res);
    };
}
