package 코드트리.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class 밭의_높이를_고르게하기 {
    private static int[] arr;
    private static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ans = new int[n-t + 1];
        /*
        arr에는 땅의 높이가 저장되어 있음
        Math.abs(arr[i] - h) 를 이용하여 비용을 계산 -> 각 구간별로 비용의 총 합을 ans[]에 입력
        윈도우의 길이는 t

        for i in range(0, n-t):
            for j in range(0, t):
                ans[i] += Math.abs(arr[i+j] - h);
        **/
        for (int i = 0; i < n - t + 1; i++) {
            for (int j = 0; j < t; j++) {
                ans[i] += Math.abs(arr[i + j] - h);
//                System.out.println("ans[i] = " + ans[i] + " || " + i);
            }
        }
        int res = Arrays.stream(ans).min().orElseThrow(() -> new NoSuchElementException(""));
        System.out.println(res);

    }
}
