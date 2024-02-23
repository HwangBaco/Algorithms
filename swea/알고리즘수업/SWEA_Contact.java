package 알고리즘연습.swea.알고리즘수업;

import java.io.*;
import java.util.*;

/**
 * @author HwangBaco
 * @algorithm
 * @time 인접행렬을 구성하면 될듯
 * BFS 탐색하여 노드들 리스트에 담으면 됨. 이때, new Node(order, node number);
 * 노드 별로 연락받은 순서 (내림차순), 노드 번호 순서 (내림차순) 정렬 하고 맨 앞에서 출력하면 될듯?
 */
public class SWEA_Contact {
    private static boolean[] visited;
    private static Queue<Pair> pq;

    private static class Pair {
        int order, idx;

        public Pair(int order, int idx) {
            this.order = order;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            sb.append(String.format("#%d ", i));
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken()) >> 1;
            int start = Integer.parseInt(st.nextToken());
            visited = new boolean[101];
            pq = new PriorityQueue<>((o1, o2) -> {
                if (o1.order == o2.order) {
                    return o2.idx - o1.idx;
                }
                return o2.order - o1.order;
            });

            st = new StringTokenizer(br.readLine());
            HashSet<Integer>[] adj = new HashSet[101];
            for (int j = 0; j < 101; j++) {
                adj[j] = new HashSet<>();
            }
            for (int j = 0; j < length; j++) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                adj[s].add(e); // 유향그래프
            }

            bfs(start, adj);
            sb.append(pq.poll().idx).append("\n");

        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(int start, HashSet<Integer>[] adj) {
        Queue<Pair> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(new Pair(0, start));

        while (!q.isEmpty()) {
            Pair now = q.poll();
            int idx = now.idx;
            if (adj[idx] == null) {
                continue;
            }
            for (int i : adj[idx]) {
                if (!visited[i]) {
                    visited[i] = true;
                    int nextOrder = now.order + 1;
                    q.add(new Pair(nextOrder, i));
                    pq.add(new Pair(nextOrder, i));
                }
            }
        }
    }
}
