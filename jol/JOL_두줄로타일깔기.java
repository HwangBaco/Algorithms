package 알고리즘연습.jol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JOL_두줄로타일깔기 {
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
        }
        System.out.println(go(n));
    }

    private static int go(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 3;
        }

        return dp[n] = (go(n - 1) + go(n - 2) * 2) % 20100529;
    }
}
