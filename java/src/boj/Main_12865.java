package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {
    public static final int WEIGHT = 0;
    public static final int VALUE = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][k+1];
        int[][] items = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items[i][WEIGHT] = w;
            items[i][VALUE] = v;
        }
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w < k+1; w++) {
                if (items[i][WEIGHT] <= w) { // 최대 무게를 안넘는 경우
                    if ((items[i][VALUE] + dp[i - 1][w - items[i][WEIGHT]]) > dp[i - 1][w])
                        dp[i][w] = items[i][VALUE] + dp[i - 1][w - items[i][WEIGHT]];
                    else dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
