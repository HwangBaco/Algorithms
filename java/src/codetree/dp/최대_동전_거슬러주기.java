package codetree.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대_동전_거슬러주기 {
    /*
    * n개의 동전, 금액 m을 거슬러주는 방법 중 가능한 최대 동전의 수는?
    * -> m을 구성하는 동전의 경우의 수 중 가장 많은 동전으로 구성되는 경우의 수를 구하는 문제
    *
    * 1. 백트래킹
    * n개의 동전의 금액을 더하여 O(n^m)만큼 고르는 경우가 최악의 수라고 할 수 있음 == 불가능
    *
    * 2. DP
    * -> n개의 동전은 각 value와 weight가 존재(weight는 1로 동일)
    * -> 동전을 더하여 i가 될 때의 동전의 최대 개수를 구하는 문제 ; 0-1 knapsack 유형
    * -> O(n*m)으로 해결 가능
    * (중복이 있으면 거꾸로 tabulation하면 되는데, 일단 중복을 허용하므로 그냥 tabulation하면 됨)
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[m + 1];
        int[] coin = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= m; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (i - coin[j] >= 0 && dp[i - coin[j]] != Integer.MIN_VALUE) {
                    dp[i] = Math.max(dp[i], dp[i - coin[j]] + 1);
                }
            }
        }

        System.out.println(dp[m] == Integer.MIN_VALUE ? -1 : dp[m]);
    }
}
