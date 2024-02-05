package 알고리즘연습.codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_n개의점중m개고르기 {
    private static int n, m;
    private static int ans = (int) 1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{y, x};
        }

        // 조합
        comb(0, 0, new int[m][2], arr);
        // 정답
        System.out.println(ans);
    }

    private static void comb(int start, int cnt, int[][] selected, int[][] arr) {
        if (cnt == m) {
            int dist = 0;
            for (int i = 0; i < m; i++) {
                for (int j = i+1; j < m; j++) {
                    int[] p1 = selected[i];
                    int[] p2 = selected[j];
                    dist = Math.max(dist, (int) Math.pow(p1[0] - p2[0], 2) + (int) Math.pow(p1[1] - p2[1], 2));
                }
            }
            ans = Math.min(ans, dist);
            return;
        }
        for (int i = start; i < n; i++) {
            selected[cnt] = arr[i];
            comb(i + 1, cnt + 1, selected, arr);
        }

    }
}
