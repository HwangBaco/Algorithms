package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2482_색상환 {
    private static int N, K;
    private static int[][] dp;
    private static final int INF = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        dp = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = INF;
            }
        }

        for (int i = 1; i <= N; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
        }

        go(N, K);
        int ans = (dp[N-3][K-1] + dp[N-1][K])  % ((int) 1e9 + 3);
        System.out.println(ans);
    }

    private static int go(int i, int j) {
        if (i <= 0 || j <= 0) {
            return 0;
        }
        if (dp[i][j] != INF) {
            return dp[i][j];
        }
        return dp[i][j] = (go(i - 2, j - 1) + go(i - 1, j)) % ((int) 1e9 + 3);
    }
}
