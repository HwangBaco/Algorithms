package 알고리즘연습.codetree.시간단축.전처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeTree_괄호쌍만들어주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int l = s.length();
        char prev = s.charAt(0);
        int[] open = new int[l];
        int cnt = 0;
        for (int i = 1; i < l; i++) {
            char c = s.charAt(i);
            if (prev == '(' && c == '(') {
                cnt++;
            }
            open[i] = cnt;
            prev = c;
        }
        prev = s.charAt(l - 1);
        long ans = 0;
        for (int i = l-2; i >= 0; i--) {
            char c = s.charAt(i);
            if (prev == ')' && c == ')') {
                ans += open[i];
            }
            prev = c;
        }
        System.out.println(ans);
    }
}
