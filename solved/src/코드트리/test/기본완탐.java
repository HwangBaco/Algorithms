package 코드트리.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기본완탐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken())-1;
        int c1 = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine());
        int r2 = Integer.parseInt(st.nextToken())-1;
        int c2 = Integer.parseInt(st.nextToken())-1;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (arr[i][j] >= k) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
