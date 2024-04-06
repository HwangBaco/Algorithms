package 알고리즘연습.codetree.legacy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CodeTree_연속한K개의숫자 {
    private static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 숫자 범위
        int k = Integer.parseInt(st.nextToken()); // k개의 연속
        int b = Integer.parseInt(st.nextToken()); // 없는 숫자 개수 b
        int ans = getAnswerByBasicImplementation(b, k, n);
//        int ans = getAnswerByPrefixSum(n, k, b);
        System.out.println(ans);
    }

    private static int getAnswerByBasicImplementation(int b, int k, int n) throws IOException {
        // time complexity : O(N)
        // 실행 시간 : 372ms
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < b; i++) {
            s.add(Integer.parseInt(br.readLine()));
        }

        int cnt = (int) IntStream.rangeClosed(1, k).filter(s::contains).count(); // 없는 숫자 카운트

        int[] ps = new int[n + 1];
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] + i;
            arr[i] = s.contains(i) ? 0 : i;
        }
        int ans = cnt;
        // 1부터 n까지
        for (int i = k + 1; i <= n; i++) {
            if (i != arr[i]) {
                cnt++;
            }
            if ((i - k) != arr[i - k]) {
                cnt--;
            }
            ans = Math.min(ans, cnt);
        }
        return ans;
    }

    private static int getAnswerByPrefixSum(int n, int k, int b) throws IOException{
        // time complexity : O(N)
        // 실행 시간 : 125ms
        int[] arr = new int[n + 1];
        for (int i = 0; i < b; i++) {
            int idx = Integer.parseInt(br.readLine());
            arr[idx] = 1; // 해당하지 않는 인덱스는 0으로 초기화됨
        }
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        int ans = Integer.MAX_VALUE;

        for (int i = k; i <= n; i++) {
            ans = Math.min(ans, prefixSum[i] - prefixSum[i - k]);
        }
        return ans;
    }

}
