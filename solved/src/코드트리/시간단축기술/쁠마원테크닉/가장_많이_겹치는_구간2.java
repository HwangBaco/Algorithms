package 코드트리.시간단축기술.쁠마원테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 가장_많이_겹치는_구간2 {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            /* 주어지는 좌표가 모두 다르므로 */
            map.put(a, 1);
            map.put(b, -1);
        }
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            cnt += map.get(key);
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

}
