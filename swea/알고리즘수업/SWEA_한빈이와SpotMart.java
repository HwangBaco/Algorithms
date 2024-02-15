package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class SWEA_한빈이와SpotMart {
    /*
    * DP?
    *
    * 이진탐색?
    *
    * 조합 (백트래킹)?
    * */
    static int ans = -1;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            ans = -1;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[] weights = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            comb(0, 0, 0, weights);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void comb(int cnt, int start, int res, int[] weights) {
        if (cnt == 2) {
            if (res <= M) {
                ans = Math.max(ans, res);
            }
            return;
        }

        for (int i = start; i < N; i++) {
            comb(cnt + 1, i + 1, res + weights[i], weights);
        }
    }
}
