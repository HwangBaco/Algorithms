package 코드트리.완전탐색.밀고당기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트 {
    private static int n, t;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[2][n];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            } else if (i == 1) {
                for (int j = n-1; j >= 0; j--) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        /*
        * t loop
        * */
        for (int i = 0; i < t; i++) {
            int temp1 = arr[1][0];
            int temp2 = arr[0][n-1];
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    for (int k = n-2; k >= 0; k--) {
                        arr[j][k+1] = arr[j][k];
                    }
                    arr[0][0] = temp1;
                } else if (j == 1) {
                    for (int k = 0; k < n - 1; k++) {
                        arr[j][k] = arr[j][k+1];
                    }
                    arr[1][n-1] = temp2;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else if (i == 1) {
                for (int j = n-1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
