package 알고리즘연습.codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class CodeTree_연속한K개의숫자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 숫자 범위
        int k = Integer.parseInt(st.nextToken()); // k개의 연속
        int b = Integer.parseInt(st.nextToken()); // 없는 숫자 개수 b
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < b; i++) {
            s.add(Integer.parseInt(br.readLine()));
        }

        int cnt = (int) IntStream.rangeClosed(1, k).filter(s::contains).count(); // 없는 숫자 카운트

        int[] ps = new int[n+1];
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i-1] + i;
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
        System.out.println(ans);
    }
}
