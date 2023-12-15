package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//홀수 짝수에 따른 출력값
public class T0036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fun(n));

    }

    private static int fun(int n) {
        if (n % 2 == 1) {
            if (n == 1) {
                return 1;
            }
            return fun(n - 2) + n;
        } else {
            if (n == 2) {
                return 2;
            }
            return fun(n-2) + n;
        }
    }
}
