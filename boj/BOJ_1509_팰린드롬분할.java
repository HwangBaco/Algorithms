package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BOJ_1509_팰린드롬분할 {
    private static int[] dp;
    private static boolean[][] isPalindrome;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        dp = new int[len+1];
        for (int i = 0; i <= len; i++) {
            dp[i] = i;
        }

        isPalindrome = new boolean[len][len];

        // palindrome of size 1
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }

        // palindrome of size 2
        for (int i = 1; i < len; i++) {
            isPalindrome[i - 1][i] = (s.charAt(i - 1) == s.charAt(i));
        }

        // palindrome of the size from 3 to len
        for (int i = 3; i <= len; i++) { // size
            for (int j = 0; j <= len - i; j++) {
                isPalindrome[j][j+i-1] = (s.charAt(j) == s.charAt(j+i-1)) && isPalindrome[j+1][j+i-2];
            }
        }

        for (int end = 1; end <= len; end++) {
            for (int start = 1; start <= end; start++) {
                if (isPalindrome[start-1][end-1]) {
                    dp[end] = Math.min(dp[end], dp[start - 1] + 1);
                } else {
                    dp[end] = Math.min(dp[end], dp[end - 1] + 1);
                }
            }
        }
        System.out.println(dp[len]);

    }

}
