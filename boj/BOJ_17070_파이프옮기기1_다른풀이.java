package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1_다른풀이 {
    /*
    * 실행시간 : 264 ms
    * 메모리 : 18140 KB
    *
    * 레슨런 : BFS를 이용하여 객체를 생성하고 저장해야 하는 경우엔, DFS로 인자를 넘겨서 간소화할 수 있을지 고민하자.
    * */
    private static int n;
    private static int[][] grid;
    private static int ans;
    static int[] dy = {0, 1, 1};
    static int[] dx = {1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        dfs(1, 2, 0);
        
        System.out.println(ans);
    }

    private static void dfs_simple(int y, int x, int dir) {
        if (y == n && x == n) {
            ans++;
            return;
        }

        if (canGo(y, x+1) && canTurn(dir, 0)) {
            dfs(y, x + 1, 0);
        }
        if (canGo(y+1, x+1) && canTurn(dir, 1) && (grid[y+1][x] == 0 && grid[y][x+1] == 0)) {
            dfs(y+1, x + 1, 1);
        }
        if (canGo(y+1, x) && canTurn(dir, 2)) {
            dfs(y+1, x, 2);
        }
    }

    private static void dfs(int y, int x, int dir) {
        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (canGo(ny, nx) && canTurn(dir, i)) {
                if (i == 1 && (grid[ny][nx-1] != 0 || grid[ny-1][nx] != 0)) {
                    // 대각선 이동 추가조건
                    continue;
                }
                if (ny == n && nx == n) {
                    ans++;
                    continue;
                }
                dfs(ny, nx, i);
            }
        }
    }
    private static boolean canTurn(int nowDir, int turn) {
        return Math.abs(nowDir - turn) < 2;
    }
    private static boolean canGo(int y, int x) {
        return inRange(y,x) && grid[y][x] == 0;
    }
    private static boolean inRange(int y, int x) {
        return y >= 1 && y <= n && x >= 1 && x <= n;
    }
}
