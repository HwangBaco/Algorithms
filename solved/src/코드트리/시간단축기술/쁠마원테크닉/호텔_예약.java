package 코드트리.시간단축기술.쁠마원테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class 호텔_예약 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.putIfAbsent(a, 0);
            map.putIfAbsent(b+1, 0);
            map.replace(a, map.get(a) + 1);
            map.replace(b+1, map.get(b+1) - 1);
        }
        long cnt = 0;
        for (Integer k : map.keySet()) {
            cnt += map.get(k);
            set.add(cnt);
        }
        System.out.println(set.last());

    }
}
