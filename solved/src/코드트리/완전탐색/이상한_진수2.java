package 코드트리.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이상한_진수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        // 0이 있는 경우
        int ans = 0;
        boolean isFin = false;
        for (int i = 0; i < s.length(); i++) {
            String ss = s.substring(i, i + 1);
            if (!isFin && ss.equals("0")) {
                isFin = true;
                ss = "1";
            }
            ans = (ans)*2 + Integer.parseInt(ss);
        }
        if (!isFin) {
            ans -= 1;
        }
        System.out.println(ans);
    }
}
