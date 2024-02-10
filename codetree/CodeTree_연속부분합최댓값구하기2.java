package 알고리즘연습.codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class CodeTree_연속부분합최댓값구하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int idx = 0;
        int res = 0;
        int ans = Integer.MIN_VALUE;
        while (true) {
            if (idx == n) {
                break;
            }

            if (res < 0) {
                res = 0;
            }
            res += arr[idx];
            ans = Math.max(ans, res);
            idx++;
        }
        System.out.println(ans);
    }
}
