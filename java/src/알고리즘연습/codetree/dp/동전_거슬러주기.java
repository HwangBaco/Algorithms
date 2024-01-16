package 알고리즘연습.codetree.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_거슬러주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /*
        * 동전의 종류만 정해져 있고, 최대 동전의 수는 제한이 없음
        * 지금까지 선택한 동전의 합이 같다면(value가 동일하다면)
        * 지금까지 사용한 동전의 개수가 많을수록 더 좋다. (여기서는 개수로 함)
        * -> 두 가지 조건을 저울질하면서 최선의 결과를 뽑아내는 게 DP
        * dp[i] : 지금까지 선택한 동전의 합이 i일 때, 가능한 최대 동전의 개수
        *
        * n개의 동전의 종류가 주어졌을 때, 금액 M을 거슬러주기 위해 필요한 최소 동전의 수는?
        * dp[i] : 금액 i를 거슬러주기 위해 필요한 최소 동전의 수.
        * */
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[m+1];
        int[] coin = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= m; i++) {
            dp[i] = 10000;
        }
        for (int i = 1; i <= n; i++) {
            if (m >= coin[i]) {
                dp[coin[i]] = 1;
            }
        }

        for (int price = 1; price <= m; price++) {
            for (int j = 1; j <= n; j++) {
                if (price - coin[j] > 0) { // 거슬러줄 수 있는 경우
                    dp[price] = Math.min(dp[price], dp[price - coin[j]] + 1);
                }
            }
        }

        System.out.println((dp[m] == 0 || dp[m] == 10001) ? -1 : dp[m]);

    }
}
