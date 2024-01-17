package 알고리즘연습.codetree.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 더하기_1_2_5 {
    public static int n, ans;
    public static int[] arr = new int[]{1, 2, 5};
    /*
    * 1. 백트래킹
    * 선택지가 3개 + 최악의 경우 n개의 숫자를 더해야 하므로 시간복잡도는 O(3^n) == 불가능
    * 2. DP
    * 1부터 n까지의 합에 대하여 경우의 수를 조사하므로 O(n)으로 해결 가능 == 가능
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i - arr[j] >= 0) {
                    dp[i] += dp[i - arr[j]];
                    dp[i] = dp[i] % 10007;
                }
            }
        }

        System.out.println(dp[n]);
    }
}
