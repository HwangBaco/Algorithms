package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 모든 집을 칠하는 비용의 최솟값
// N이 최대 1000

// 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
// N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
// i(2 <= i <= N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

// 즉, 이웃한 집의 색은 같지 않아야 한다.

// 그리디는 안먹힌다. 전반적으로 봤을 때 경우에 따라 중간 가격대를 배치해야 최소가 될 수 있으니,
// 앞의 경우가 뒤에서 사용될 수 있는가?(DP인가?) -> dp다. 격자 dp
public class BOJ_1149_RGB거리 {
    // 시간 : 140 ms
    private static int N;
    private static int[][] price;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        price = new int[N][3];
        dp = new int[N][3];

        // 가격 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
            // 첫줄 초기화
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = price[i][j];
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]) + price[i][j];
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]) + price[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 2], dp[i - 1][j - 1]) + price[i][j];
                }
            }
        }
        int ans = (int) 1e9;

        for (int i = 0; i < 3; i++) {
            ans = Math.min(dp[N - 1][i], ans);
        }
        System.out.println(ans);
    }

}
