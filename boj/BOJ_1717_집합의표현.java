package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_1717_집합의표현 {
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정수의 개수 n
        int m = Integer.parseInt(st.nextToken()); // 연산의 횟수 m
        parent = IntStream.rangeClosed(0,n).toArray();

        // 연산 종류
        // 0 a b : a가 포함된 집합과 b가 포함된 집합을 합친다. (union)
        // 1 a b : a와 b가 같은 집합 안에 있다면 1을, 그렇지 않다면 0을 출력 (find)

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (cmd == 0) {
                union(a,b);
            } else {
                int aRoot = find(a);
                int bRoot = find(b);
                System.out.println(aRoot == bRoot ? "YES" : "NO");
            }
        }
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) {
            return;
        }
        // 작은 값 기준으로 부모 설정
        if (aRoot < bRoot) {
            parent[bRoot] = aRoot;
        } else {
            parent[aRoot] = bRoot;
        }
    }
    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        int root = find(parent[a]);
        parent[a] = root;
        return root;
    }
}
