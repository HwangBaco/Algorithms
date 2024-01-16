package 코드트리.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_사각형_최대_합 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // init dp
        int[][] dp = new int[n+1][n+1];
        dp[1][1] = arr[1][1];
        for (int i = 2; i <= n; i++) {
            dp[1][i] = dp[1][i - 1] + arr[1][i];
        }
        for (int i = 2; i <= n; i++) {
            dp[i][1] = dp[i-1][1] + arr[i][1];
        }

        // tabulation operation
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1] + arr[i][j], dp[i - 1][j] + arr[i][j]);
            }
        }

        System.out.println(dp[n][n]);
    }
}
