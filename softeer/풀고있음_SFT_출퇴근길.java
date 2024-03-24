package 알고리즘연습.softeer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @algorithm 완탐-dfs
 * @time O(V+E) ; 인접리스트 활용
 * @memory
 */
public class 풀고있음_SFT_출퇴근길 {
    private static int N, M, S, T;
    private static List<Integer>[] adj;
    private static ArrayList<Long>[] go;
    private static ArrayList<Long>[] back;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        int size = N / 63 + 1;
        go = new ArrayList[size];
        back = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            go[i] = new ArrayList<>();
            back[i] = new ArrayList<>();
        }

        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        long[] visited = new long[size];
        go(S, T, visited, new boolean[N+1][N+1], go);
        visited = new long[N / 63 + 1];
        go(T, S, visited, new boolean[N+1][N+1], back);

        int cnt = 0;
        HashSet<Integer> gs = new HashSet<>();
        HashSet<Integer> bs = new HashSet<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Long> gos = go[i];
            ArrayList<Long> backs = back[i];
            for (Long l : gos) {
                for (int j = 0; j < 63; j++) {
                    if ((l & 1L << j) != 0) {
                        gs.add(63 * i + j);
//                        System.out.println("63 * i + j = " + 63 * i + j);
                    }
                }
            }
//            System.out.println("--------------");
            for (Long l : backs) {
                for (int j = 0; j < 63; j++) {
                    if ((l & 1L << j) != 0) {
                        bs.add(63 * i + j);
//                        System.out.println("63 * i + j = " + 63 * i + j);
                    }
                }
            }
        }
        for (Integer b : gs) {
            if (bs.contains(b)) {
                cnt++;
            }
        }

        br.close();
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    private static void go(int start, int dest, long[] visited, boolean[][] visitEdges, ArrayList<Long>[] visitList) {
        for (int v : adj[start]) {
//            System.out.println("from : " + start);
//            System.out.println("to : " + v);
            if (!visitEdges[start][v]) {
                if (v == dest) {
                    // 방문했던 곳들 모두 저장
                    int l = visited.length;
                    for (int i = 0; i < l; i++) {
                        visitList[i].add(visited[i]);
                    }
                    continue;
                }
                visitEdges[start][v] = true;
                visited[v / 63] |= 1L << (v % 63);
                go(v, dest, visited, visitEdges, visitList);
            }
        }
    }
}
