package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * int[] D : 각 건물당 건설에 걸리는 시간
 * X, Y : 건설 순서 (X -> Y)
 * W : 백준이가 승리하기 위해 건설해야 할 건물의 번호
 */
public class BOJ_1005_ACMCraft_copy {
    /**
     *
     *
     * @return minimum time to build W
     */
    static int N, K, X, Y, W;
    static int[] D;
    static List<Integer>[] edges;
    static int[] inDegree;
    static int[] dp;
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        final int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            D = new int[N+1];
            dp = new int[N + 1];
            edges = new ArrayList[N+1];
            inDegree = new int[N+1];
            for (int i = 1; i <= N; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i = 1; i <= N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                edges[X].add(Y);
                inDegree[Y]++;
            }
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    dp[i] = D[i]; // init
                    q.add(i); // 탐색 순서 정의
                }
            }

            W = Integer.parseInt(br.readLine());

            List<Integer> sorted = new ArrayList<>();
            while (!q.isEmpty()) {
                Integer now = q.poll();
                for (int next : edges[now]) {
                    inDegree[next]--;
                    dp[next] = Math.max(dp[next], dp[now] + D[next]);
                    if (inDegree[next] == 0) {
                        q.add(next);
                    }
                }
            }

            sb.append(dp[W]).append("\n");
        }
        System.out.println(sb);
    }


}
