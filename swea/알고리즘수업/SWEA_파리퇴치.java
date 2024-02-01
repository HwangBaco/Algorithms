package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_파리퇴치 {
    public static void main(String[] args) throws IOException {
        /*
        * n x n 배열 안의 숫자는 해당 영역 안에 존재하는 파리의 개수르 의미한다.
        *
        * T 인력
        * n, m 입력
        * 배열 입력 (n x n 배열 입력받고 어떻게 m x m 으로 골랐을 때 가장 클지 탐색)
        *
        * 1. 누적합 이용하여 m x m 탐색하는 시간 절약
        *
        * 2. 영역 완탐 (int i = m ; i < n ; i ++)
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
            int ans = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] ps = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    ps[i][j] = num + ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1];
                }
            }
            for (int i = m; i <= n; i++) {
                for (int j = m; j <= n; j++) {
                    int res = ps[i][j] - ps[i - m][j] - ps[i][j - m] + ps[i - m][j - m];
                    ans = Math.max(ans, res);
                }
            }

            System.out.printf("#%d %d\n", tc, ans);;
        }
    }
}
