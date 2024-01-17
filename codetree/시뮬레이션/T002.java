package 코드트리.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int[] daysOfMonths = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int elapsedDate1 = 0;
        for (int i = 0; i < m1; i++) {
            elapsedDate1 += daysOfMonths[i];
        }
        elapsedDate1 += d1;

        int elapsedDate2 = 0;
        for (int i = 0; i < m2; i++) {
            elapsedDate2 += daysOfMonths[i];
        }
        elapsedDate2 += d2;

        int ans = elapsedDate2 - elapsedDate1 + 1;
        System.out.println(ans);
    }
}
