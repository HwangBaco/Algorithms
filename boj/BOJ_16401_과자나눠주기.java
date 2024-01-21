package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16401_과자나눠주기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nephewsCnt = Integer.parseInt(st.nextToken());
        int cookiesCnt = Integer.parseInt(st.nextToken());

        // init
        int[] cookies = new int[cookiesCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cookiesCnt; i++) {
            cookies[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cookies);

        // binary search
        int left = 1;
        int right = (int) 1e9;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = Arrays.stream(cookies).map(cookie -> cookie / mid).sum();
            if (cnt >= nephewsCnt) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
