package 코드트리.완전탐색.밀고당기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼각_컨베이어벨트 {
    private static int n, t;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[3][n];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < t; i++) {
            int t1 = arr[0][n-1];
            int t2 = arr[1][n-1];
            int t3 = arr[2][n-1];
            for (int j = 0; j < 3; j++) {
                for (int k = n-1; k > 0; k--) {
                    arr[j][k] = arr[j][k-1];
                }
                if (j == 0) {
                    arr[j][0] = t3;
                } else if (j == 1) {
                    arr[j][0] = t1;
                } else if (j == 2) {
                    arr[j][0] = t2;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
