package 알고리즘연습.codetree.legacy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CodeTree_별이있는숫자로만이동 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        int[][] ps = new int[n + 1][n + 1]; // prefix sum

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                ps[i][j] = ps[i][j-1] + arr[i][j];
            }
        }

        int ans = 0;
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) { // O(N^2)
                // y, x : 중앙점
                int sum = 0;
                for (int r = y - k; r <= y + k; r++) { // O(*K)
                    int c = k - Math.abs(r - y);
                    if (r >= 1 && r <= n) {
                        sum += ps[r][Math.min(x + c, n)] - ps[r][Math.max(x - c - 1, 0)];
                    }
                }
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
    }

    public static void main2() throws IOException {
    }
}
