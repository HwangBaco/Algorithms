package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {
    static int n, ans;
    static int[] dx = new int[]{1, 1, 0};
    static int[] dy = new int[]{0, 1, 1};

    static int[][] arr;

    static class Pipe {
        int y, x, p;

        Pipe(int y, int x, int p) {
            this.y = y;
            this.x = x;
            this.p = p;
        }
    }

    static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    static boolean canGo(int y, int x, int p) {
        if (p == 0 || p == 2) {
            if (inRange(y, x) && arr[y][x] == 0) {
                return true;
            }
        } else if (p == 1) {
            if (inRange(y, x) && arr[y][x] == 0 && arr[y - 1][x] == 0 && arr[y][x - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    static void dfs(Pipe now) {
        if (now.y == n-1 && now.x == n-1) {
            ans++;
            return;
        }
        if (now.p == 0) {
            for (int i = 0; i < 2; i++) {
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if (canGo(newY, newX, i)) {
                    dfs(new Pipe(newY, newX, i));
                }
            }
        } else if (now.p == 1) {
            for (int i = 0; i <= 2; i++) {
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if (canGo(newY, newX, i)) {
                    dfs(new Pipe(newY, newX, i));
                }
            }
        } else if (now.p == 2) {
            for (int i = 1; i <= 2; i++) {
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if (canGo(newY, newX, i)) {
                    dfs(new Pipe(newY, newX, i));
                }
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        ans = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(new Pipe(0, 1, 0));
        System.out.println(ans);
    }
}
