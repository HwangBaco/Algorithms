package 알고리즘연습.codetree.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 부분_수열의_합이_m {
    public static void main(String[] args) throws IOException {
        /*
        * n개의 원소로 이루어진 수열 A
        * 수열 A의 부분 수열 내 원소의 합이 m이 되는 경우 중 가능한 최소 수열의 길이는?
        * (순서 중요)
        *
        * 가장 중요한 아이디어는, 중복되지 않도록 dp를 수행하기 위해 tabulation이 아니라 memoization으로 한다는 것.
        *
        * dp[i] : 수열 내 원소의 합이 i가 되는 경우 중 가능한 최소 수열의 길이
        * if (sum >= arr[i]): // 연산이 가능한 경우
        *   dp[i] = Math.min(dp[i], dp[i - li.get(j)] + 1)
        *
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] dp = new int[m+1];
        Queue<Integer> pq = new PriorityQueue<>();

        // init arr
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // init dp
        for (int i = 1; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;
        }


        for (int i = 1; i <= n; i++) { // 순서 중요
            for (int sum = m; sum >= 0; sum--) {
                if (sum >= arr[i]) {
                    if (dp[sum - arr[i]] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[sum] = Math.min(dp[sum], dp[sum - arr[i]] + 1);
                }
            }
        }
        System.out.println(dp[m] == Integer.MAX_VALUE? -1 : dp[m]);
    }
}
