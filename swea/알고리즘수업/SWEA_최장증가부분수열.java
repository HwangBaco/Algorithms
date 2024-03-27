package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_최장증가부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i] = 1; // 자기만 고려했을 때의 길이
            }

            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    if (i == 0) {
                        break;
                    }
                    if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
                max = Math.max(dp[i], max);
            }
            sb.append(String.format("#%d %d", tc, max)).append("\n");
        }
        System.out.println(sb.toString());

    }
}
