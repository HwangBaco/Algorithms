package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {
    private static int N, M, R;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < Math.min(N, M) / 2; i++) {
            int r = R % ((((N - 2 * i) - 1) + (M - 2 * i) - 1) * 2);
            for (int j = 0; j < r; j++) {
                rotate(i);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void rotate(int x) {
        int temp = arr[x][x];

        // top left
        for (int i = x; i < M - x - 1; i++) {
            arr[x][i] = arr[x][i+1];
        }
        // right up
        for (int i = x; i < N - x - 1; i++) {
            arr[i][M - x - 1] = arr[i + 1][M - x - 1];
        }
        // bottom right
        for (int i = M - x - 1; i > x; i--) {
            arr[N - x - 1][i] = arr[N - x - 1][i - 1];
        }
        // left down
        for (int i = N - x - 1; i > x; i--) {
            arr[i][x] = arr[i - 1][x];
        }
        arr[x+1][x] = temp;
    }
}
