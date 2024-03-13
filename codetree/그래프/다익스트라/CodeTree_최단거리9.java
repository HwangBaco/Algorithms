package 알고리즘연습.codetree.그래프.다익스트라;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class CodeTree_최단거리9 {
    private static int N, M;
    private static int[][] map;
    private static boolean[] visited;
    private static int[] dist;
    private static int[] path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        path = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 양방향
            map[s][e] = w;
            map[e][s] = w;
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            dist[i] = (int) 1e9;
        }
        dist[a] = 0;


        for (int i = 1; i <= N; i++) {
            int minIdx = -1;

            for (int j = 1; j <= N; j++) {
                if (visited[j]) {
                    continue;
                }
                if (minIdx == -1 || dist[minIdx] > dist[j]) {
                    minIdx = j;
                }
            }

            visited[minIdx] = true;

            for (int j = 1; j <= N; j++) {
                if (map[minIdx][j] == 0) {
                    continue;
                }
                if (dist[j] > dist[minIdx] + map[minIdx][j]) {
                    dist[j] = dist[minIdx] + map[minIdx][j];
                    path[j] = minIdx;
                }
            }
        }
        sb.append(dist[b]).append("\n");

        int idx = b;
        List<Integer> li = new ArrayList<>();
        li.add(idx);
        while (idx != a) {
            idx = path[idx];
            li.add(idx);
        }
        for (int i = li.size() - 1; i >= 0; i--) {
            sb.append(li.get(i)).append(" ");
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
