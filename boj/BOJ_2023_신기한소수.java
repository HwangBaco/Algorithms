package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023_신기한소수 {
    /*
    * 시간 : 132 ms (소수 탐색을 x 미만까지 돌면 856 ms)
    *
    * 공간 : 14196 KB
    * */
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int[] prefix = {2, 3, 5, 7};
        for (int i : prefix) {
            int num = i;
            go(1, n, num);
        }
    }

    private static void go(int depth, int n, int num) {
        int[] arr = {1, 3, 7, 9};
        if (!isPrime(num)) {
            return;
        }
        if (depth == n) {
            System.out.println(num);
        }
        for (int i = 0; i < 5; i++) {
            int next = num*10 + arr[i];
            go(depth + 1, n, next);
        }
    }

    // 에라토스테네스의 체
    private static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
