package boj.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1922 {

    // 알고리즘 : 크루스칼

    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Pair> li = new ArrayList<>();
        parent = new int[n+1];

        // init list
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            li.add(new Pair(dis, a, b));
        }
        int res = 0;
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        li.sort((o1, o2) -> {
            return o1.dis - o2.dis;
        });

        for (Pair p : li) {

            if (find(p.a) != find(p.b)) {
                union(p.a, p.b);
                res += p.dis;
            }
        }
        System.out.println(res);
    }

    public static int find(int v) {
        if (parent[v] == v) {
            return v;
        }
        parent[v] = find(parent[v]);
        return parent[v];
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    public static class Pair {
        int a, b, dis;

        public Pair(int dis, int a, int b) {
            this.dis = dis;
            this.a = a;
            this.b = b;
        }
    }
}
