package 알고리즘연습.codetree.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeTree_수들의합최대화하기 {
    private static int N, ans;
    private static int[] rows; // elem : col
    private static int[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        rows = new int[N];
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.fill(rows, -1);
        go(0);

        System.out.println(ans);
    }

    private static void go(int depth) {
        if (depth == N) {
            int res = 0;
            for (int row = 0; row < N; row++) {
                int col = rows[row];
                res += grid[row][col];
            }
            ans = Math.max(ans, res);
            return;
        }
        top:
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < depth; i++) {
                if (j == rows[i]) {
                    continue top;
                }
            }
            rows[depth] = j;
            go(depth+1);
            rows[depth] = -1;
        }
    }
}
