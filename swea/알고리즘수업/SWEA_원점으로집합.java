<<<<<<< Updated upstream
package algorithm.오늘푼문제0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_원점으로집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            solution(br, sb, tc);
        }
        System.out.println(sb.toString());
    }

    private static void solution(BufferedReader br, StringBuilder sb, int tc) throws IOException {
        StringTokenizer st;
        long n = Integer.parseInt(br.readLine());
        long max = -1;
        int oddBit = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long abs = Math.abs(a) + Math.abs(b);
            if (i == 0) {
                oddBit = abs % 2 == 1 ? 1 : 0;
            } else {
                if ((abs % 2 != oddBit) && !flag) {
                    flag = true;
                }
            }
            max = Math.max(max, abs);
        }
        if (flag) {
            sb.append(String.format("#%d -1\n", tc));
            return;
        }
        // max가 구해진 상황
        long i = 0;
        long j = 0;
        while (j < max) {
            j += ++i;
        }
        j -= max;
        while (j % 2 == 1) {
            j += ++i;
        }
        sb.append(String.format("#%d %d\n", tc, i));
    }
}
=======
package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_원점으로집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            solution(br, sb, tc);
        }
        System.out.println(sb.toString());
    }

    private static void solution(BufferedReader br, StringBuilder sb, int tc) throws IOException {
        StringTokenizer st;
        long n = Integer.parseInt(br.readLine());
        long max = -1;
        int oddBit = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long abs = Math.abs(a) + Math.abs(b);
            if (i == 0) {
                oddBit = abs % 2 == 1 ? 1 : 0;
            } else {
                if (!(abs % 2 == oddBit)) {
                    sb.append(String.format("#%d %d\n", tc, -1));
                    return;
                }
            }
            max = Math.max(max, abs);
        }
        // max가 구해진 상황
        long i = 0;
        long j = 0;
        while (j < max) {
            j += ++i;
        }
        j -= max;
        while (j % 2 == 1) {
            j += ++i;
        }
        sb.append(String.format("#%d %d\n", tc, i));
    }
}
>>>>>>> Stashed changes
