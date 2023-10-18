package 코드트리.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계단오르기_메모이제이션 {
    private static int n;
    private static int[] dp;
    public static final int MAX_N = 1001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new int[MAX_N];
        for (int i = 0; i < MAX_N; i++) {
            dp[i] = -1;
        }
        int ans = memoization(n);
        if (ans == -1) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }

    private static int memoization(int i) {
        if (dp[i] != -1) {
            return dp[i];
        }
        if (i == 1) {
            return 0;
        } else if (i == 2 || i == 3) {
            return 1;
        }
        dp[i] = (memoization(i - 2) + memoization(i - 3)) % 10007;
        return dp[i];

    }
}
