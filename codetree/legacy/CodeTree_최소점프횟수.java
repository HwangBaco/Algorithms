package 알고리즘연습.codetree.legacy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class CodeTree_최소점프횟수 {
    /*
    * 시간복잡도 : O(2^N * N)
    *
    * 수행 시간 : 260 ms
    *
    * 메모리 : 14 MB
    *
    * 로직 :
    * 1. 0번 노드부터 시작하여, capability 범위 안에서 노드를 재귀로 고름.
    * 2. 끝까지 도달했을 때 hop의 수를 minimum 연산하여 정답 도출
    * */

    private static int ans = (int) 1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // n : 10 이하
        // 주어지는 숫자 : 4 이하

        // n개의 숫자를 고르고, 그 숫자를 모두 탐색한다고 해도 2^N * N 이므로 시간복잡도는 충분 => 완탐

        // 일단 무조건 첫 번째 노드는 골라야 함.
        // 첫 번째 노드의 범위만큼 노드를 선택하고 큐에 넣음,
        comb(0, arr, n, 0);
        System.out.println(ans == (int) 1e9 ? -1 : ans);

    }

    private static void comb(int cnt, int[] arr, int n, int hops) {
        if (cnt == n - 1) {
            ans = Math.min(ans, hops);
            return;
        }
        if (cnt < n - 1) {
            int cap = arr[cnt];
            for (int i = 1; i <= cap; i++) {
                if (cnt + i < n) {
                    comb(cnt + i, arr, n, hops + 1);
                }
            }
        }
    }
}
