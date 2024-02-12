package 알고리즘연습.codetree.그래프.플로이드워셜;

import java.io.*;
import java.util.StringTokenizer;

public class CodeTree_행렬로주어진간선 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] adj = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String ans = solution(n, adj);

        bw.write(ans);

        br.close();
        bw.flush();
        bw.close();
    }

    private static String solution(int n, int[][] adj) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (adj[i][k] + adj[k][j] >= 2) {
                        adj[i][j] = 1;
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (adj[i][j] >= 1 || i == j) {
                    sb.append("1 ");
                    continue;
                }
                sb.append("0 ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
