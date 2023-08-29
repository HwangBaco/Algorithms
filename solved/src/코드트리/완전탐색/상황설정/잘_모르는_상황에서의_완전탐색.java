package 코드트리.완전탐색.상황설정;

import java.io.IOException;

public class 잘_모르는_상황에서의_완전탐색 {
    private static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 10; i++) {
            int n = i, res = 0;
            while (n != 1) {
                if (n % 2 == 1) {
                    n = n * 3 + 1;
                } else {
                    n /= 2;
                }
                res++;
            }
            ans = Math.max(ans, res);
        }
        System.out.println(ans);
    }
}
