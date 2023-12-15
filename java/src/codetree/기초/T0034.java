package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀함수를 이용한 피보나치 수
public class T0034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fib(n));
    }

    private static int fib(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
