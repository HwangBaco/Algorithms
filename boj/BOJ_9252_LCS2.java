package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9252_LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String ss = br.readLine();
        int[][] dp = new int[s.length()+1][ss.length()+1];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < ss.length(); j++) {
                if (s.charAt(i) == ss.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        System.out.println(dp[s.length()][ss.length()]);
        StringBuilder sb = new StringBuilder();
        int sl = s.length()-1;
        int ssl = ss.length()-1;
        while (sl >= 0 && ssl >= 0) {
            if (dp[sl + 1][ssl] == dp[sl + 1][ssl + 1]) {
                ssl--;
            } else if (dp[sl][ssl + 1] == dp[sl + 1][ssl + 1]) {
                sl--;
            } else {
                sb.append(s.charAt(sl));
                sl--;
                ssl--;
            }
        }
        System.out.println(sb.reverse());
    }
}
