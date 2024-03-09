package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15666_N과M12 {
    private static int N, M;
    private static HashSet<Integer> hs = new HashSet<>();
    private static int[] arr;
    private static int[] selected;
    private static String prev;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hs.add(Integer.parseInt(st.nextToken()));
        }
        int i = 0;
        for (Integer h : hs) {
            arr[i++] = h;
        }
        Arrays.sort(arr);
        arr = Arrays.stream(arr).filter(o -> o != 0).toArray();
        prev = "";
        perm(0);
        br.close();
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            if (!sb.toString().equals(prev)) {
                System.out.println(sb.toString());
                prev = sb.toString();
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (cnt > 0 && selected[cnt - 1] <= arr[i]) {
                selected[cnt] = arr[i];
                perm(cnt + 1);
            } else if (cnt == 0) {
                selected[cnt] = arr[i];
                perm(cnt+1);
            }
        }
    }
}
