package 코드트리.완전탐색.상황설정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 야바위 {
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n, a, b, c;
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 3; i++) {
            if (i == 1) {
                a = 1;
                b = 0;
            } else if (i == 2) {
                b = 2;
            }
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

            }

        }
    }

    private static int switchStone(int number) {
        if (number == 1) {
            return 0;
        } else {
            return 1;
        }
    }
}
