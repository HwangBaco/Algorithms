package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기 {
    // 시간 : 176 ms
    // 메모리 : 43072 KB
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = (int) 1e9;
        }

        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= 3; i++) {
            if (i <= n) {
                dp[i] = 1;
            }
        }

        System.out.println(go(n));
    }

    private static int go(int n) {
        if (dp[n] != (int) 1e9) {
            return dp[n];
        }
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 1;
        }

        if (n % 3 == 0) {
            dp[n] = Math.min(dp[n], go(n / 3) + 1);
        }
        if (n % 2 == 0) {
            dp[n] = Math.min(dp[n], go(n / 2) + 1);
        }
        return dp[n] = Math.min(dp[n], go(n - 1) + 1);
    }
}
