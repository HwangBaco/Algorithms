package 코드트리.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사각형_채우기_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[1001];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;

        for (int i = 3; i <= 1000; i++) {
            dp[i] = mod(mod(2 * dp[i - 1]) + mod(3 * dp[i - 2]));
            for (int j = i-3; j >= 0; j--) {
                dp[i] = mod(dp[i] + mod(2 * dp[j]));
            }
        }
        System.out.println(dp[n]);

    }

    private static long mod(long num) {
        return num % 1000000007;
    }
}
