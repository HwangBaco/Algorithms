package 코드트리.릴레이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자10부터_합을_구하는_함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 10; i <= n; i++) {
            ans += i;
        }
        System.out.println(ans);
    }
}
