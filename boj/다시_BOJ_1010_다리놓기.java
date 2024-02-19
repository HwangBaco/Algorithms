package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다시_BOJ_1010_다리놓기 {
    private static int N, M;
    private static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int[][] dp = new int[31][31];
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ans = 0;
            if (dp[M][N] != 0) {
                sb.append(dp[M][N]).append("\n");
            } else {
                comb(0, 0);
                dp[M][N] = ans;
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb.toString());
    }


    private static void comb(int start, int cnt) {
        if (cnt == N) {
            ans++;
            return;
        }
        for (int i = start; i < M; i++) {
            comb(i + 1, cnt + 1);
        }
    }
}
