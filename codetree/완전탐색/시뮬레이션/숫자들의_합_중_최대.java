package 코드트리.완전탐색.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자들의_합_중_최대 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int ans = Integer.MIN_VALUE;
        for (int i = x; i <= y; i++) {
            int temp;
            int res = 0;
            if (i < 10) {
                ans = Math.max(ans, i);
            } else {
                temp = i;
                while (temp >= 1) {
                    res += temp % 10;
                    temp /= 10;
                }
                ans = Math.max(ans, res);
            }
        }
        System.out.println(ans);
    }

}
