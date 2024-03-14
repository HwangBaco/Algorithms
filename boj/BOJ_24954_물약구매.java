package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_24954_물약구매 {
    private static int N;
    private static int[] arr;
    private static List<int[]>[] adj;
    private static int[] costs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        arr = new int[N];
        costs = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        for (int v = 1; v <= N; v++) {
            int loopCnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < loopCnt; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()); // u
                int w = Integer.parseInt(st.nextToken()); // w
                adj[v].add(new int[]{u, w});
            }
        }
        int ans = (int) 1e9;
        do {
            ans = Math.min(go(), ans);
        } while (np());
        System.out.println(ans);
    }

    private static int go() {
        int res = 0;
        int[] temp = costs.clone();
        for (int i : arr) {
            // 일단 그거 가격 더하고,
            res += temp[i];
            if (adj[i] == null) {
                continue;
            }
            for (int[] now : adj[i]) {
                int u = now[0];
                int w = now[1];
                temp[u] = temp[u] <= w ? 1 : temp[u] - w;
            }
        }
        return res;
    }

    private static boolean np() {
        final int LI = arr.length - 1;

        int i = LI;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            --i;
        }

        if (i == 0) {
            return false;
        }

        int j = LI;
        while (arr[i - 1] >= arr[j]) {
            --j;
        }
        swap(i - 1, j);

        int k = LI;
        while (i < k) {
            swap(i++, k--);
        }

        return true;
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
