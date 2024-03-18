package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1700_멀티탭스케줄링 {
    static int N, K;
    static HashSet<Integer> selected = new HashSet<>();
    static HashMap<Integer, Boolean> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int ans = 0;

        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        top:
        for (int i = 0; i < K; i++) {
            if (selected.size() < N || selected.contains(arr[i])) {
                selected.add(arr[i]);
                continue;
            }
            List<Integer> use = new ArrayList<>();
            for (int j = K-1; j >= i; j--) {
                if (selected.contains(arr[j])) {
                    use.add(arr[j]);
                }
            }
            // 미래에 안쓰일 놈이면
            for (Integer k : selected) {
                if (!use.contains(k)) {
                    selected.remove(k);
                    selected.add(arr[i]);
                    ans++;
                    continue top;
                }
            }

            // 전부 다 쓰일 거면 가장 나중에 등장하는 애를 지움
            if (!use.isEmpty()) {
                selected.remove(use.get(0));
                selected.add(arr[i]);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
