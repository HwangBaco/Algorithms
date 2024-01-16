package 코드트리.완전탐색.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팰린드롬_문자열뒤집는방법O {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        /*
        길이를 반으로 쪼개서 저장
        하나를 반전시켜서 두 개의 문자열이 동일하면 ans++
        **/
        int ans = 0;
        for (int i = x; i <= y; i++) {
            String s = String.valueOf(i);
            String a, b;
            int idx = s.length();
            if (idx % 2 == 0) {
                a = s.substring(0, idx / 2);
                // 문자열 뒤집는 방법
                b = new StringBuffer(s.substring(idx / 2, idx)).reverse().toString();
            } else {
                a = s.substring(0, idx/2);
                b = new StringBuffer(s.substring(idx / 2 + 1, idx)).reverse().toString();
            }
            if (a.equals(b)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
