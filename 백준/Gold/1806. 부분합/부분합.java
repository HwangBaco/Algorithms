import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    /**
     * c1. '연속된 수들의 부분합'
     * c2. 길이 N의 수열
     * c3. 1 <= elem <= 10_000
     * c4. 10 <= N <= 100_000
     * c5. 0 <= S <= 100_000_000
     *
     * => 누적합 + 투포인터로 하면 O(N)으로 해결 가능
     *
     * @return 합이 S 이상이 되는 것 중 가장 짧은 길이
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long[] ps = new long[N+1];

        ps[1] = arr[0];
        for (int i = 1; i < N; i++) {
            ps[i+1] = ps[i] + arr[i];
        }

        long ans = (int) 1e9;
        int left = 1;
        int right = 1;
        long res = 0;
        while (right <= N) {
            if (left <= right) {
                res = ps[right] - ps[left - 1];
                if (res >= S) {
                    ans = Math.min(ans, right - left + 1);
                    left++;
                } else {
                    right++;
                }
            } else {
                right++;
            }
        }
        System.out.println(ans == (int) 1e9 ? 0 : ans);
    }
}