package 코드트리.시간단축기술.LR_테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 씨_오_더블유 {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        int[] L = new int[n + 1];
        int[] R = new int[n + 1];
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = s.substring(i, i + 1);
            if (arr[i].equals("C")) {
                L[i + 1] = L[i] + 1;
            } else {
                L[i+1] = L[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[n - i - 1].equals("W")) {
                R[i + 1] = R[i] + 1;
            } else {
                R[i+1] = R[i];
            }
        }
        int ans = 0; // point of failure
        for (int i = 1; i < n-1; i++) {
            if (arr[i].equals("O")) {
                ans += (L[i] * R[n - i - 1]);
            }
        }
        System.out.println(ans);
    }
}
