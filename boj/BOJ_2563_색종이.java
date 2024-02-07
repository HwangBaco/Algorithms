package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2563_색종이 {
    /*
    * 실행시간 : 128 ms
    * */
    private static boolean[][] colored = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for (int j = y; j < y + 10; j++) {
                for (int k = x; k < x + 10; k++) {
                    if (!colored[j][k]) {
                        colored[j][k] = true;
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}