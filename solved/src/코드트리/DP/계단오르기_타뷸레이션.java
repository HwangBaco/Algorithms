package 코드트리.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_타뷸레이션 {

    public static void main(String[] args) throws IOException {
        int[] dp = new int[1002];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3] % 10007;
        }
        System.out.println(dp[n]);

    }
}
