package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//재귀함수를 이용한 최댓값
public class T0037 {
    private static int[] arr;
    private static int ans = 0;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        max(0);
        System.out.println(ans);


    }

    private static void max(int idx) {
        if (idx >= n) {
            return;
        }
        max(idx+1);
        ans = (arr[idx] > ans) ? arr[idx] : ans;
    }
}
