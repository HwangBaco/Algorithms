package 코드트리.shortenTimeSkill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정수n개의_합3 {
    private static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        int[][] sum = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sum[i][0] = 0;
            for (int j = 0; j < n; j++) {
                sum[0][j] = 0;
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + arr[i][j];
            }
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (inRange(i + k, j + k)) {
                    queue.add(-(sum[i + k][j + k] - sum[i][j + k] - sum[i + k][j] + sum[i][j]));
                }
            }
        }
        System.out.println(-queue.poll());

    }

    public static boolean inRange(int i, int j) {
        return i <= n && j <= n;
    }
}
