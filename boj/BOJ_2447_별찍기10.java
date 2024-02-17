package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분할정복 문제
 *
 * @author 황제철
 */
public class BOJ_2447_별찍기10 {
    private static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                go(i, j, n);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void go(int r, int c, int n) {
        int size = n * n / 9;
        int first = n / 3;
        int second = n / 3;

        if (r < first) {
            if (size == 1) {
                sb.append("*");
            }

        } else if (r < second && c < first) {
            if (size == 1) {
                sb.append("*");
            }
        } else if (r < second && c < second) {
            if (size == 1) {
                sb.append(" ");
            }
        } else {
            if (size == 1) {
                sb.append("*");
            }
        }
    }
}
