package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class SWEA_서로소집합 {
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int tc = 1; tc <= T; tc++) {
            sb.append(String.format("#%d ", tc));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            parent = IntStream.rangeClosed(0, n).toArray();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (cmd == 0) {
                    union(a, b);
                } else {
                    int aRoot = find(a);
                    int bRoot = find(b);
                    sb.append(aRoot == bRoot ? 1 : 0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return;
        }
        if (aRoot > bRoot) {
            parent[aRoot] = bRoot;
        } else {
            parent[bRoot] = aRoot;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

}
