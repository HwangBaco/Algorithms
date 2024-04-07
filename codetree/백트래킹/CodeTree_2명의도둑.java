package 알고리즘연습.codetree.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeTree_2명의도둑 {
    private static int N, M, C, tmp, res, ans;
    private static int[][] grid;
    private static int[] m;
    private static boolean[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, 0, 0, 0);

        System.out.println(ans);
    }

    private static void go(int y, int x, int depth, int res) {
        if (depth == 2) {
            ans = Math.max(ans, res);
            return;
        }
        if (y == N) {
            return;
        }
        if (x > N - M) {
            go(y + 1, 0, depth, res);
            return;
        }
        getArrayM(y, x);
        selected = new boolean[M];
        tmp = 0;
        getTmp(0);
        go(y, x + M, depth + 1, res + tmp);
        go(y, x + 1, depth, res);
    }

    private static void getArrayM(int y, int x) {
        m = new int[M];
        for (int i = 0; i < M; i++) {
            m[i] = grid[y][x + i];
        }
    }

    private static void getTmp(int cnt) {
        if (cnt == M) {
            int c = 0;
            int sum = 0;
            for (int i = 0; i < M; i++) {
                if (selected[i]) {
                    c += m[i];
                    sum += (int) Math.pow(m[i], 2);
                }
            }
            if (c <= C) {
                tmp = Math.max(tmp, sum);
            }
            return;
        }
        selected[cnt] = true;
        getTmp(cnt + 1);
        selected[cnt] = false;
        getTmp(cnt + 1);
    }
}
