package 알고리즘연습.kaupc.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3 {
    private static int oddSum = 0;
    private static int evenSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                oddSum += Integer.parseInt(st.nextToken());
            } else {
                evenSum += Integer.parseInt(st.nextToken());
            }
        }
        int res = oddSum - evenSum;
        if (n == 3 && res > 0) {
            System.out.println(-1);
        } else {
            System.out.println(Math.abs(res));
        }

    }
}
