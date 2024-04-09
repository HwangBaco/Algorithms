package 알고리즘연습.codetree.시간단축.전처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CodeTree_균일하게나누기2 {
    public static final int MAX = 1000;
    private static int[][] ps = new int[MAX + 1][MAX + 1];
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ps[y][x] = 1;
        }
        for (int y = 1; y <= MAX; y++) {
            for (int x = 1; x <= MAX; x++) {
                ps[y][x] += ps[y - 1][x] + ps[y][x - 1] - ps[y - 1][x - 1];
            }
        }
        int ans = (int) 1e9;
        for (int y = 2; y <= MAX; y = y + 2) {
            for (int x = 2; x <= MAX; x = x + 2) {
                int a = ps[y][x];
                int b = ps[MAX][x] - ps[y][x] - ps[MAX][0] + ps[y][0];
                int c = ps[y][MAX] - ps[y][x] - ps[0][MAX] + ps[0][x];
                int d = ps[MAX][MAX] - ps[y][MAX] - ps[MAX][x] + ps[y][x];

                int M = Math.max(a, Math.max(b, Math.max(c, d)));
                ans = Math.min(ans, M);
            }
        }
        System.out.println(ans);
    }
}
