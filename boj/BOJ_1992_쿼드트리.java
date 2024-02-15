package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
    /*
    * 실행시간 : 264 ms
    *
    * 메모리 : 17020 KB
    * */
    static int[][] ps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        ps = new int[n+1][n+1];

        /* 배열 초기화 */
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s.substring(j,j+1));
            }
        }

        /* 누적합 구하기 */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = arr[i-1][j-1] + ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1];
            }
        }

        go(0, 0, n);
    }

    private static void go(int r, int c, int n) {
        int res = ps[n+r][n+c] - ps[n+r][c] - ps[r][n+c] + ps[r][c];
        if (res == n * n) {
            System.out.print(1);
            return;
        } else if (res == 0) {
            System.out.print(0);
            return;
        } else {
            System.out.print("(");
            n = n / 2;
            go(r, c, n);
            go(r, c + n, n);
            go(r + n, c, n);
            go(r + n, c + n, n);
            System.out.print(")");
        }
        return;
    }
}
