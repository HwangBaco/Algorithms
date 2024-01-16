package 코드트리.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_짧은_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int R = 0;
        int sum = arr[0];
        int ans = Integer.MAX_VALUE;
        for (int L = 0; L < n; L++) {
            while (R + 1 < n && sum < s) {
                R++;
                sum += arr[R];
            }
            if (R + 1 == n && sum < s) {
                break;
            }
            ans = Math.min(ans, R - L + 1);
            sum -= arr[L];
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
