package 코드트리.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (d == 11 && h < 11) {
            System.out.println(-1);
        } else if (d == 11 && h == 11 && m < 11) {
            System.out.println(-1);
        } else if (m >= 11 || d >= 12) {
            int ans = d * 24 * 60 + h * 60 + m - 11 * 24 * 60 - 11 * 60 - 11;
            System.out.println(ans);

        }

    }
}
