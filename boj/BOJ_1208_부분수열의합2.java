package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1208_부분수열의합2 {
    private static HashMap<Integer, Integer> map = new HashMap<>();
    private static long ans = 0;
    private static int S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ps(arr, new boolean[N], N / 2, N);
        ps2(arr, new boolean[N], 0, N / 2);
        if (S == 0) {
            ans--;
        }
        System.out.println(ans);
    }

    private static void ps(int[] arr, boolean[] selected, int depth, int N) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    sum += arr[i];
                }
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return;
        }
        selected[depth] = true;
        ps(arr, selected, depth+1, N);
        selected[depth] = false;
        ps(arr, selected, depth+1, N);
    }
    private static void ps2 (int[] arr, boolean[] selected, int depth, int N) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    sum += arr[i];
                }
            }
            ans += map.getOrDefault(S - sum, 0);
            return;
        }
        selected[depth] = true;
        ps2(arr, selected, depth + 1, N);
        selected[depth] = false;
        ps2(arr, selected, depth + 1, N);
    }
}
