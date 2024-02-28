package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * dp[i] : 무게 i일 때 최대 값어치
 *
 * 시간 : 212 ms
 */
public class BOJ_12865_평범한배낭 {
    private static int N, K;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        dp = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i][0] = w;
            arr[i][1] = v;
        }

        for (int j = 0; j < N; j++) {
            int weight = arr[j][0];
            int value = arr[j][1];
            for (int i = K; i >= weight; i--) { // 무게 순회하면서
                if (dp[i-weight] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - weight] + value);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= K; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
