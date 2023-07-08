package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T0033 {
    private static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        System.out.println(op(n));
    }

    private static int op(int n) {
        if (n == 1) return cnt;
        if (n % 2 == 0) {
            n /= 2;
            cnt++;
        } else {
            n /= 3;
            cnt++;
        }
        op(n);
        return cnt;
    }
}
