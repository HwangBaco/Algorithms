package 코드트리.DP;

import java.io.IOException;

public class DP_개념 {
    private static int n;
    private static int[] memo;
    private static int[] dp;
    private static final int MAX_N = 1000;
    public static void main(String[] args) throws IOException {
        // 타뷸레이션 : 바텀업
        dp = new int[MAX_N];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
        /*
        * 이론적인 시간복잡도는 두 방법이 동일하나,
        * 탑다운 방식은 함수를 재귀적으로 여러번 실행해야 하므로
        * 함수 처리에 추가적인 시간이 약간 더 붙어 실제로는 바텀업 방식이 약간 더 빠릅니다.
        * */
    }


    // 메모이제이션 : 탑다운
    private static int memoization(int i) {
        if (memo[i] != -1) {
            return memo[i];
        }
        if (i <= 2) {
            memo[i] = 1;
        } else {
            memo[i] = memoization(i - 1) + memoization(i - 2);
        }
        return memo[i];
    }
}
