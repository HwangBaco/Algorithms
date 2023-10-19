package 코드트리.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사각형_채우기 {

    public static void main(String[] args) throws IOException {
        /*
        * 계단 오르기와 동일한 패턴
        * 한 번에 1칸 오르냐 2칸 오르냐 하는 것
        * 경우의 수를 구하는 것이니까
        * f(n) = f(n-1) + f(n-2);
        * */
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 1000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
    }
}
