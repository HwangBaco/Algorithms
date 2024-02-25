package 알고리즘연습.codetree.이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수분배_참고할만한코드 {
    /*
    * 시간 : 131 ms
    * */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            max = max > nums[i] ? max : nums[i];
        }

        int start = 1, end = max, mid, ans = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;

            int cnt = 0;
            for (int i = 0; i < n; i++)
                cnt += nums[i] / mid;

            if (cnt >= m) {
                start = mid + 1;
                ans = mid;
            } else
                end = mid - 1;
        }
        System.out.println(ans);


    }
}
