package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
    /*
    * 실행시간 : 124 ms
    *
    * 메모리 : 14228 KB
    * */
    static int N, R, C;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        go(R, C, (int) Math.pow(2, N));
        System.out.println(ans);
    }

    private static void go(int r, int c, int n) {
        int matSize = (n * n) / 4;
        int y = n / 2;
        int x = n / 2;

        if (r + 1 <= y && c + 1 <= x) {
            ans += (matSize * 0);
            if (matSize == 1) {
                return;
            }
            go(r, c, n / 2);
        } else if (r + 1 <= y && c + 1 > x) {
            ans += (matSize * 1);
            if (matSize == 1) {
                return;
            }
            go(r, c - x, n / 2);
        } else if (r + 1 > y && c + 1 <= x) {
            ans += (matSize * 2);
            if (matSize == 1) {
                return;
            }
            go(r - y, c, n / 2);
        } else if (r + 1 > y && c + 1 > x) {
            ans += (matSize * 3);
            if (matSize == 1) {
                return;
            }
            go(r - y, c - x, n / 2);
        }
    }
}
