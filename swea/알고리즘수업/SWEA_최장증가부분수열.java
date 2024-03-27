package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
            Deque<Integer>[] lis = new ArrayDeque[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i] = 1; // 자기만 고려했을 때의 길이

                // 최장증가수열을 직접 구할 때
                lis[i] = new ArrayDeque<>();
                lis[i].add(arr[i]);
            }

            int max = 0;
            int idx = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    if (i == 0) {
                        break;
                    }
                    if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }

                    // LIS를 직접 구할 때
                    if (arr[i] > arr[j] && lis[i].size() < lis[j].size() + 1) {
                        lis[i].clear();
                        lis[i].addAll(lis[j]);
                        lis[i].add(arr[i]);
                    }
                }
                if (dp[i] > max) {
                    idx = i;
                }
                max = Math.max(dp[i], max);
            }
            sb.append(String.format("#%d %d", tc, max)).append("\n");
            sb.append(lis[idx].toString()).append("\n");
        }
        System.out.println(sb.toString());

    }
}
