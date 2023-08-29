package 코드트리.완전탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 자리마다_숫자_정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(getCnt(n, a, b, c, 0));

    }

    private static int getCnt(int n, int a, int b, int c, int cnt) {
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= n; k++) {
                for (int l = 1; l <= n; l++) {
                    if (Math.abs(j - a) <= 2 || Math.abs(k - b) <= 2 || Math.abs(c - l) <= 2) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
