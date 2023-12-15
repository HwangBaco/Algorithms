package 코드트리.완전탐색.시뮬레이션;

import java.io.*;
import java.util.StringTokenizer;

public class 괄호_쌍_만들기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        String s = st.nextToken();
        br.close();
        String openParenthese = "(";
        String closeParenthese = ")";
        for (int i = 0; i < s.length(); i++) {
            if (i+1 < s.length() && s.substring(i, i + 1).equals(openParenthese)) {
                for (int j = i+1; j < s.length(); j++) {
                    if (s.substring(j, j + 1).equals(closeParenthese)) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
