import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (union(a, b)) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV) {
            return true;
        }
        if (rootU > rootV) {
            parents[rootU] = rootV;
        } else {
            parents[rootV] = rootU;
        }
        return false;
    }
    private static int find(int v) {
        if (parents[v] == v) {
            return v;
        }
        return parents[v] = find(parents[v]);
    }
}