package 알고리즘연습.codetree.그래프.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CodeTree_친구의키2 {
    private static int[] inDegree;
    private static ArrayList<Integer>[] adj;
    private static int N, M;
    private static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        inDegree = new int[N];

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            adj[from].add(to);
            inDegree[to]++;
        }

        // 시작 노드 q에 추가
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            Integer now = q.poll();

            /* business logic part */
            cnt++; // 위상 정렬 가능 여부를 체크하는 로직이라 cnt 변수 사용 -> 개수 비교로 사이클 유무 확인

            for (int node : adj[now]) {
                inDegree[node]--;

                if (inDegree[node] == 0) {
                    q.add(node);
                }
            }
        }

        System.out.println(cnt == N ? "Consistent" : "Inconsistent");
    }
}
