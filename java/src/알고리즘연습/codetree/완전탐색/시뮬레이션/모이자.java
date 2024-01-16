package 코드트리.완전탐색.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class 모이자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        // 완전탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i] += arr[j] * Math.abs(i-j);
            }
        }
        int res = Arrays.stream(ans).min().orElseThrow(() -> new NoSuchElementException(""));
        System.out.println(res);
    }
}
