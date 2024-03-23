package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_일이삼더하기 {
    private static int[] dp = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = -1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            sb.append(go(n)).append("\n");
        }
        System.out.println(sb.toString());

    }

    private static int go(int i) {
        if (dp[i] != 0) {
            return dp[i];
        }
        return dp[i] = go(i - 1) + go(i - 2) + go(i - 3);
    }
}
