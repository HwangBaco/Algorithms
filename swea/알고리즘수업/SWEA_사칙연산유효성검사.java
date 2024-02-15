package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_사칙연산유효성검사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(br.readLine());
            int ans = 1;
            while (n-- > 0) {
                String[] f = br.readLine().split(" ");
                if (f.length > 2 && !isOp(f[1])) {
                    ans = 0;
                }
            }
            System.out.printf("#%d %d\n", i, ans);
        }


    }

    private static boolean isOp(String s) {
        if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
            return true;
        }
        return false;
    }
}
