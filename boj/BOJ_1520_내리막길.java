package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @intuition 경우의 수 저장 배열 선언하고, 이동 가능하면 경우의 수 배열 갱신
 *
 * @algorithm dfs + dp
 * @time O(NM) dfs탐색하면서 dp 저장하는게 전부 ->
 * @memory O(NM) ->
 */
public class BOJ_1520_내리막길 {
    private static int[][] map; // 높이 저장
    private static int[][] dp; // 해당 위치로 이동할 수 있는 최대 경우의 수
    private static int M, N; // M : 세로 , N : 가로 (500이하 자연수)
    private static int H; // 정답 (이동 가능한 경로의 수 - 10억 이하의 음이 아닌 정수);
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 초기화
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;

        // bfs 수행하여 H = dp[M-1][N-1];
        dfs(0,0, true); // 시작점 (0,0)
        System.out.println(H);
    }
    private static int dfs(int y, int x, boolean canRenew) {
        // visited는 안 해도 됨 (항상 높이가 낮은 곳으로만 이동이 가능하니)
        int prevHeight = map[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (canGo(ny, nx, prevHeight)) {
                if (canRenew && dp[ny][nx] != -1) { // 초행길도 아닌데 renew 가능이면 경우의 수 추가
                    dp[ny][nx] = dp[y][x] + 1;
                    canRenew = false;
                } else {
                    dp[ny][nx] = Math.max(dp[y][x], dp[ny][nx]);
                }
                dfs(ny, nx, canRenew);
                canRenew = true;
            }
        }

        return H = dp[M - 1][N - 1];
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < M && x >= 0 && x < N;
    }

    private static boolean canGo(int y, int x, int prevHeight) {
        return inRange(y, x) && map[y][x] < prevHeight; // 범위 내 이동이며, 내리막인 경우
    }

}
