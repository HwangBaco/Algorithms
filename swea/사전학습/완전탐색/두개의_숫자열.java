package 알고리즘연습.swea.사전학습.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두개의_숫자열 {
    private static BufferedReader br;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        // 숫자열은 최소 1개 ~ 최대 n, m개
        // n, m은 3 이상 20 이하

        // 완탐으로 푼다면, 최대 20번의 루프를 통해 위치를 변경
        // 위치 변경한 상태에서 곱셈하여 max 연산 수행
        // 최댓값을 구하기만 하면 되므로 이렇게 하면 끝
        // -> 완탐으로 푸는 문제

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] nrr = new int[n];
            int[] mrr = new int[m];
            initArray(n, nrr);
            initArray(m, mrr);
            int offset = 0;
            int ans = Integer.MIN_VALUE;
            // n < m이라고 가정
            if (n < m) {
                while (true) {
                    int res = 0;
                    if (offset + n - 1 > m - 1) {
                        break;
                    }
                    for (int j = 0; j < n; j++) {
                        res += (nrr[j] * mrr[offset + j]);
                    }
                    ans = Math.max(res, ans);
                    offset++;
                }
            } else if (n > m) {
                while (true) {
                    int res = 0;
                    if (offset + m - 1 > n - 1) {
                        break;
                    }
                    for (int j = 0; j < m; j++) {
                        res += (mrr[j] * nrr[offset + j]);
                    }
                    ans = Math.max(res, ans);
                    offset++;
                }
            } else {
                int res = 0;
                for (int j = 0; j < n; j++) {
                    res += (mrr[j] * nrr[j]);
                }
                ans = res;
            }
            StringBuffer sb = new StringBuffer().append("#").append(i).append(" ").append(ans);
            System.out.println(sb);
        }
    }

    private static void initArray(int m, int[] mrr) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            mrr[j] = Integer.parseInt(st.nextToken());
        }
    }
}
