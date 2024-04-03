package 알고리즘연습.swea.알고리즘수업;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// 2,033 ms, 104,412 kb
public class SWEA_키순서 {
    private static int N, M;
    private static int a, b;

    private static int[][] from;
    private static int[][] to;
    public static final int INF = (int) 1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            from = new int[N+1][N+1];
            to = new int[N+1][N+1];

            Arrays.stream(from)
                    .forEach(i -> Arrays.fill(i, INF));
            Arrays.stream(to)
                    .forEach(i -> Arrays.fill(i, INF));

            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                from[a][b] = 1;
                to[b][a] = 1;
            }



            // 연결 구조가 나왔으니, 서로 연결되어 있는지 여부를 체크
            // 플로이드워셜로 풀어서 한 노드라도 거리를 알 수 없는 녀석은 out
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        from[i][j] = Math.min(from[i][j], from[i][k] + from[k][j]);
                    }
                }
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        to[i][j] = Math.min(to[i][j], to[i][k] + to[k][j]);
                    }
                }
            }
            int ans = 0;
            top:
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        continue; // 자기자신은 생략
                    }
                    if (from[i][j] == INF && to[i][j] == INF) { // 양쪽 다 모르면
                        continue top; // next node
                    }
                }
                ans++;
            }
            sb.append(String.format("#%d %d\n", tc, ans));
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
