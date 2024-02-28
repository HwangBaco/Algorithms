package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * time : 136 ms
 */
public class BOJ_17069_파이프옮기기2 {
    private static int N;
    private static final int MAX_N = 32;
    private static long[][][] dp = new long[MAX_N][MAX_N][3];
    private static int[][] map;
    private static int[] dx = {1, 1, 0};
    private static int[] dy = {0, 1, 1};
    private static final int HORIZONTAL = 0; // 가로
    private static final int DIAGONAL = 1; // 대각
    private static final int VERTICAL = 2; // 세로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j][HORIZONTAL] = -1;
                dp[i][j][DIAGONAL] = -1;
                dp[i][j][VERTICAL] = -1;
            }
        }
        dp[0][1][HORIZONTAL] = 1;
        
        // dp 호출
        go(N - 1, N - 1, HORIZONTAL);
        go(N - 1, N - 1, VERTICAL);
        go(N - 1, N - 1, DIAGONAL);

//        for (int i = 0; i < 3; i++) {
//            System.out.println("===========");
//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < N; k++) {
//                    System.out.print(dp[j][k][i] + " ");
//                }
//                System.out.println();
//            }
//        }

        System.out.println((dp[N - 1][N - 1][VERTICAL] == -1 ? 0 : dp[N - 1][N - 1][VERTICAL]) + (dp[N - 1][N - 1][HORIZONTAL] == -1 ? 0 : dp[N - 1][N - 1][HORIZONTAL]) + (dp[N - 1][N - 1][DIAGONAL] == -1 ? 0 : dp[N - 1][N - 1][DIAGONAL]));
    }

    private static long go(int y, int x, int dir) {
        if (!inRange(y, x)) { // 범위를 벗어난 호출
            return 0;
        }
        if (x > 1 && y > 0 && dir == DIAGONAL) { // 대각선 이동 조건
            if (map[y - 1][x] != 0 || map[y][x - 1] != 0) {
                return 0;
            }
        }
        if (map[y][x] != 0) { // 기본 이동 조건
            return 0;
        }

        // 이미 값이 있으면 그거 반환
        if (dp[y][x][dir] != -1) {
            return dp[y][x][dir];
        }
        return dp[y][x][dir] = (dir == HORIZONTAL ? go(y, x - 1, HORIZONTAL) + go(y, x - 1, DIAGONAL) : (dir == VERTICAL ? go(y - 1, x, VERTICAL) + go(y - 1, x, DIAGONAL) : go(y - 1, x - 1, HORIZONTAL) + go(y - 1, x - 1, VERTICAL) + go(y - 1, x - 1, DIAGONAL)));
    }

    private static boolean inRange(int y, int x) {
        if (y == 0) {
            return x >= 1 && x < N - 1;
        }
        return y > 0 && y < N && x >= 2 && x < N;
    }
}
