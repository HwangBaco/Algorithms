package ssafy.사전학습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파리퇴치3 {
    private static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            // init array
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    // (j, k) 좌표가 중간 지점
                    int res = arr[j][k];
                    for (int l = 1; l < m; l++) {
                        if (inRange(j - l, k)) {
                            res += arr[j - l][k];
                        }
                        if (inRange(j + l, k)) {
                            res += arr[j + l][k];
                        }
                        if (inRange(j, k - l)) {
                            res += arr[j][k - l];
                        }
                        if (inRange(j, k + l)) {
                            res += arr[j][k + l];
                        }
                    }
                    ans = Math.max(ans, res);
                    res = arr[j][k];
                    for (int l = 1; l < m; l++) {
                        if (inRange(j - l, k - l)) {
                            res += arr[j - l][k - l];
                        }
                        if (inRange(j - l, k + l)) {
                            res += arr[j - l][k + l];
                        }
                        if (inRange(j + l, k - l)) {
                            res += arr[j + l][k - l];
                        }
                        if (inRange(j + l, k + l)) {
                            res += arr[j + l][k + l];
                        }
                    }
                    ans = Math.max(ans, res);
                }
            }
            System.out.println("#" + i + " " + ans);

        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
