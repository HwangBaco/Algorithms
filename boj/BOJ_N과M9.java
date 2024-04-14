package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_N과M9 {
    private static int N, M;

    private static int[] arr;
    private static int[] selected;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        go(0, 0);
        System.out.println(sb);
    }
    private static void go(int depth, int visited) {
        if (depth == M) {
            Arrays.stream(selected)
                    .forEach(i -> sb.append(i).append(" "));
            sb.append("\n");
            return;
        }
        int prev = -1;
        for (int i = 0; i < N; i++) {

            if (prev == arr[i] || (visited & 1 << i) != 0) {
                continue;
            }
            prev = arr[i];
            selected[depth] = arr[i];
            go(depth+1, visited | 1 << i);
        }
    }
}
