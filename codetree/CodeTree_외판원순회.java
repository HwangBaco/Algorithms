package 알고리즘연습.codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class CodeTree_외판원순회 {
    static int n;
    static int ans = (int) 1e9;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        // TPS : 순열을 이용하여 풀어보자

        // 순열은 조합과 달리, 순서를 고려해야 하므로 항상 고를 수 있는 숫자를 모두 열어두고, 중복을 방지하려면 장치를 마련하여 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        // 순열
        for (int i = 0; i < n; i++) {
            perm(1, 1 << i, i, i, 0);
        }
        System.out.println(ans);
    }

    private static void perm(int depth, int visited, int crtNode, int startNode, int res) {
        if (depth == n) {
            if (arr[crtNode][startNode] > 0) {
                ans = Math.min(ans, res + arr[crtNode][startNode]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if ((visited & 1 << i) != 0 || arr[crtNode][i] == 0) {
                continue;
            }
            perm(depth + 1, visited | 1 << i, i, startNode, res + arr[crtNode][i]);
        }
    }
}
