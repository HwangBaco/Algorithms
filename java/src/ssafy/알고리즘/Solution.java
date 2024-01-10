package ssafy.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static final int VALUE = 0;
    public static final int CALORIES = 1;
    public static void main(String[] args) throws IOException {

        // 사용 알고리즘 : 0/1 knapsack problem(dp)
        // 수행시간 : 152 ms
        // 메모리 사용량 : 32,128 kb
        /*
        * 로직 요약:
        * (처음엔 dp인줄 모르고, 조합을 구하는건가 싶어 백트래킹으로 접근했는데, 나중에 계산해보니까 백트래킹으로 풀 경우 시간복잡도가 ...)
        * "햄버거를 담는다 or 담지 않는다" subProblem으로 설정하여, 무게가 기준을 넘을 경우 -> 담지 않고, else -> 해당 햄버거를 담느냐 or 기존 값이 더 크냐 로 점화식 구함
        * 점화식 ~ DP[k][w] = max(DP[k-1][w], DP[k-1][w-wk] + val(wk))
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[][] dp = new int[n+1][l+1];
            int[][] hamburgers = new int[n + 1][2];

            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                hamburgers[j][VALUE] = v;
                hamburgers[j][CALORIES] = c;
            }
            for (int j = 1; j <= n; j++) {
                for (int c = 1; c <= l; c++) {
                    if (hamburgers[j][CALORIES] < c) {
                        if (dp[j - 1][c] < dp[j - 1][c - hamburgers[j][CALORIES]] + hamburgers[j][VALUE]) {
                            dp[j][c] = dp[j - 1][c - hamburgers[j][CALORIES]] + hamburgers[j][VALUE];
                        } else {
                            dp[j][c] = dp[j - 1][c];
                        }
                    } else {
                        dp[j][c] = dp[j-1][c]; // 추가하지 않는 걸로
                    }
                }
            }
            System.out.println("#" + i + " " + dp[n][l]);
        }
    }
}
