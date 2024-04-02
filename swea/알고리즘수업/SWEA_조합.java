package algorithm.오늘푼문제0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_조합 {
    static long[] fac = new long[1_000_000 + 1];
    static final long MOD_VAL = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        fac[1] = 1L;
        for (int i = 2; i <= 1_000_000; i++) {
            fac[i] = mod(fac[i - 1] * i);
        }

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            long e = mod((fac[q - w]) * (fac[w]));
            long r = mod(pow(e, MOD_VAL - 2));
            System.out.println(String.format("#%d %d", tc ,mod(r * fac[q])));
        }
    }

    private static long mod(long n) {
        return n % MOD_VAL;
    }
    private static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long k = pow(a, b / 2) % MOD_VAL;
        return ((b % 2 == 0 ? 1 : a) * ((k * k) % MOD_VAL)) % MOD_VAL;
    }

}
