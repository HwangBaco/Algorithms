package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T0032 {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ans = 0;
        f(n);
        System.out.println(ans);

    }
    private static int f(int n) {
        if (n >= 0 && n < 10) return ans += (n*n);
        return ans += f(n/10) + ((n%10) * (n%10));
    }
}
