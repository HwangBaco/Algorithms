package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_하나로 {
    private static class Edge {
        int u,v;
        double w;

        public Edge(int u, int v, double w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    private static int N;
    private static double E;
    private static int[] parent;
    private static Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o.w));
    public static void main(String[] args) throws IOException {
        /*
        * T : 테케 개수
        * N : 섬의 개수 (노드 개수) ~ 1천 이하 자연수
        * x,y : 섬들의 정수 좌표 ~ 백만 이하 양의 정수
        * E : 환경 부담 세율 실수 (0 이상 1 이하)
        *
        * weight : (E * L^2)
        *
        * 0. 어차피 모든 섬이 연결될 수 있으니까, x y 리스트 따로 입력받고
        *
        * 1. y, x ~ 루프 돌려서 가중치 전체 계산해서 간선리스트 작성 List<edge>
        * 2. 간선리스트를 크루스칼 돌리면 끝 // parent[],
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append(String.format("#%d ", tc));
            double ans = 0;

            N = Integer.parseInt(br.readLine());
            parent = new int[N];

            int[] X = new int[N];
            int[] Y = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                X[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                Y[i] = Integer.parseInt(st.nextToken());
            }

            E = Double.parseDouble(br.readLine());

            for (int i = 0; i < N; i++) {
                int ax = X[i];
                int ay = Y[i];
                for (int j = i+1; j < N; j++) {
                    int bx = X[j];
                    int by = Y[j];
                    pq.add(new Edge(i, j, E * (sq(ax - bx) + sq(ay - by))));
                }
            }

            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            while (!pq.isEmpty()) {
                Edge e = pq.poll();
                int u = e.u;
                int v = e.v;
                double w = e.w;
                if (find(u) == find(v)) {
                    continue;
                }
                union(u, v);
                ans += w;
            }
            sb.append(Math.round(ans)).append("\n");
        }
        System.out.println(sb);
    }

    private static long sq(long a) {
        return a * a;
    }

    private static int find(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    private static void union(int u, int v) {
        int uRoot = find(u);
        int vRoot = find(v);
        if (uRoot == vRoot) {
            return;
        }
        if (uRoot < vRoot) {
            parent[vRoot] = uRoot;
            return;
        }
        parent[uRoot] = vRoot;
    }
}
