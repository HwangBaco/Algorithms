package 알고리즘연습.swea.알고리즘수업;

import java.io.*;
import java.util.StringTokenizer;

// 1,293 ms, 107,684 kb
public class SWEA_사람네트워크2 {
    private static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] map = new int[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solution(N, map);
            sb.append(String.format("#%d %d\n", tc, ans));
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void solution(int N, int[][] map) {
        int[][] dist = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] > 0) {
                    dist[i][j] = map[i][j];
                } else {
                    dist[i][j] = (int) 1e9;
                }
            }
            dist[i][i] = 0;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int min = (int) 1e9;
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == (int) 1e9) {
                    continue;
                }
                arr[i] += dist[i][j];
            }
            min = Math.min(min, arr[i]);
        }
        ans = min;
    }
}
