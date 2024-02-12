package 알고리즘연습.codetree.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class CodeTree_연속부분합최댓값구하기2 {
    /*
    * 알고리즘 : 그리디
    * 
    * 구간 내 최대값을 구할 때, 누적합이 음수로 되는 부분은 절대 최대가 될 수 없음을 이용하여 그리디로 풀이
    * */
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
