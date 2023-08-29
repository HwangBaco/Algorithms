package 코드트리.시간단축기술.LR_테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_외_최대숫자 {
    private static int n, q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        int[] L = new int[n + 1];
        int[] R = new int[n + 1];
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            L[i + 1] = Math.max(L[i], arr[i]);
        }
        for (int i = 0; i < n; i++) {
            R[i + 1] = Math.max(R[i], arr[n - i - 1]);
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(Math.max(L[a - 1], R[n - b]));
        }
    }
}
