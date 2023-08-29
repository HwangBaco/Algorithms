package 코드트리.시간단축기술.LR_테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 인접하지_않은_3개의_숫자 {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] L_max = new int[n+1];
        int[] R_max = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            L_max[i] = Math.max(L_max[i - 1], arr[i - 1]);
        }
        for (int i = 1; i <= n; i++) {
            R_max[i] = Math.max(R_max[i - 1], arr[n - i]);
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 2; i < n-2; i++) {
            set.add(L_max[i - 1] + arr[i] + R_max[n - i - 2]);
        }
        System.out.println(set.last());

    }
}
