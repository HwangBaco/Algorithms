package 코드트리.완전탐색.forLoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행복한_수열의_개수 {
    private static int n, m, ans;
    private static int[][] arr1;
    private static int[][] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr1 = new int[n][n];
        arr2 = new int[n][n];
        ans = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr1[i][j] = num;
                arr2[j][i] = num;
            }
        }
        if (m == 1) {
            ans = n * 2;
        } else {
            for (int i = 0; i < n; i++) {
                int isInARowCnt1 = 0;
                int isInARowCnt2 = 0;
                boolean isInARow1 = false;
                boolean isInARow2 = false;

                for (int j = 1; j < n; j++) {
                    if (arr1[i][j] == arr1[i][j-1]) {
                        isInARowCnt1 += (isInARowCnt1 == 0) ? 2 : 1;
                    } else {
                        isInARowCnt1 = 0;
                    }
                    if (isInARowCnt1 >= m) {
                        isInARow1 = true;
                    }
                    if (arr2[i][j] == arr2[i][j - 1]) {
                        isInARowCnt2 += (isInARowCnt2 == 0) ? 2 : 1;
                    } else {
                        isInARowCnt2 = 0;
                    }
                    if (isInARowCnt2 >= m) {
                        isInARow2 = true;
                    }
                }
                if (isInARow1) {
                    ans++;
                }
                if (isInARow2) {
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}
