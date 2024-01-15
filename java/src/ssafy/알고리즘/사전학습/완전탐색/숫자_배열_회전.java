package ssafy.알고리즘.사전학습.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자_배열_회전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= t; i++) {
            System.out.println("#" + i);
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            initArr(n, br, arr);
            for (int j = 0; j < n; j++) {
                StringBuffer firstSb = new StringBuffer();
                StringBuffer secondSb = new StringBuffer();
                StringBuffer thirdSb = new StringBuffer();
                for (int k = 1; k <= n; k++) {
                    firstSb.append(arr[n - k][0 + j]);
                    secondSb.append(arr[n - j - 1][n - k]);
                    thirdSb.append(arr[0 + k - 1][n - j - 1]);
                }
                System.out.println(firstSb + " " + secondSb + " " + thirdSb);
            }
        }
    }

    private static void initArr(int n, BufferedReader br, int[][] arr) throws IOException {
        StringTokenizer st;
        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                arr[j][k] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
