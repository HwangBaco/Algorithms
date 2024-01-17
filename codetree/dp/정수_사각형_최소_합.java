package 코드트리.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_사각형_최소_합 {
    private static int n;
    private static int[][] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // init
        dp[0][n-1] = arr[0][n-1];

        for (int i = n-2; i >= 0; i--) {
            dp[0][i] = arr[0][i] + dp[0][i + 1];
        }
        for (int i = 1; i < n; i++) {
            dp[i][n-1] = arr[i][n-1] + dp[i-1][n-1];
        }

        // tabulation
        for (int i = 1; i < n; i++) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i - 1][j] + arr[i][j], dp[i][j + 1] + arr[i][j]);
            }
        }

        System.out.println(dp[n-1][0]);
    }
}
