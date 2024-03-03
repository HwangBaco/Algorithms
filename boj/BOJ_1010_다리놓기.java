package 알고리즘연습.boj;

import java.io.*;
import java.util.StringTokenizer;

/**
* 답 참고. (조합을 매번 연산하기엔 시간복잡도가 2^30이라 초과함. 결론적으로, 조합 공식을 알고 있었어야 한 문제)
* 필요한 조합 공식 : (n+1) C (r+1) = (n) C (r) + n C (r+1); && (n) C (0) == (n) C (n) == 1;
* @intuition X
* @algorithm dp
* @time O(M*N) -> 132 ms
* @memory O(M*N) -> 15252 KB
*/
public class BOJ_1010_다리놓기 {
    private static int T, N, M;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dp = new int[M + 1][N + 1];
            int res = go(M, N);
            sb.append(res).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    private static int go(int m, int n) {
        if (dp[m][n] != 0) {
            return dp[m][n];
        }
        if (n == 0 || m == n) {
            return 1;
        }
        return dp[m][n] = go(m - 1, n - 1) + go(m - 1, n);
    }

}
