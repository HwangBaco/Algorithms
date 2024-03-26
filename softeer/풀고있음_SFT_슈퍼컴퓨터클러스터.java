package 알고리즘연습.softeer;

import java.io.*;
import java.util.*;

/**
 * N대의 컴퓨터
 * Ai : i번째 컴퓨터의 성능
 * d : 성능을 d만큼 향상시키는 데에 드는 비용이 d^2
 * B : 업그레이드에 사용되는 예산
 *
 * @algorithm binary search
 * @time O(N * logA) ; A의 범위가 10e9이며, 이 범위를 이진탐색하면서 loop N 진행
 * @memory O(N)
 * @return 가장 작은 수가 최대가 되는 경우에서의 가장 낮은 성능 수
 */
public class 풀고있음_SFT_슈퍼컴퓨터클러스터 {
    private static int N; // 1e5
    private static long B; // 1e18
    private static Map<Integer, Integer> mapper = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 오름차순 정렬
        for (int i : arr) { // O(N)
            mapper.put(i, mapper.getOrDefault(i, 0) + 1); // 각 성능의 개수
        }

        int left = arr[0];
        int right = (int) 2e9;
        int mid = 0;
        long res = 0;
        int ans = 0;

        top:
        while (left <= right) {
            res = 0;
            mid = (left + right) / 2; // 목표 성능
            for (Integer performance : mapper.keySet()) {
                if (mid <= performance) {
                    break;
                }
                long temp = mid - performance;
                res += (temp * temp) * mapper.get(performance);
                if (res > B) { // 이미 성능 넘었으면 목표치가 너무 큰 거임
                    right = mid - 1;
                    ans = right;
                    continue top;
                }
            }
            // 여기까지 왔으면 B를 넘지 않는 총합이 구해진 상태인거임
            ans = mid;
            left = mid + 1; // 더 키워보자
        }
        System.out.println(ans);
    }
}
