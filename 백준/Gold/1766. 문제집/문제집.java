import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] inDegree = new int[N + 1];
        List<Integer>[] edges = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            inDegree[b]++;
        }
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            pq.add(i);
        }
        // indegree가 0인 애들을 오름차순으로 먼저 출력 (우선순위 큐)
        // 그 중에서 edges를 갖고 있는 애들은 edges 해결

        boolean[] visited = new boolean[N + 1];

        while(!pq.isEmpty()) {
            int now = pq.poll();
            if (inDegree[now] > 0 || visited[now]) {
                continue;
            }
            sb.append(now).append(" ");
            visited[now] = true;
            for (int i : edges[now]) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    pq.add(i);
                }
            }
        }
        System.out.println(sb);
    }

}