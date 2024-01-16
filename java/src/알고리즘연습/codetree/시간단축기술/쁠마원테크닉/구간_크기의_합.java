package 코드트리.시간단축기술.쁠마원테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class 구간_크기의_합 {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(a, 1);
            map.put(b, -1);
        }
        long ans = 0;
        long cnt = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer key : map.keySet()) {
            cnt += map.get(key);
            System.out.println(cnt);
            set.add(key);
            if (cnt == 0) {
                ans += Math.abs(set.first() - set.last());
                set = new TreeSet<>();
            }
            if (key.equals(map.lastKey()) && set.size() > 1) {
                ans += Math.abs(set.first() - set.last());
            }
        }
        System.out.println(ans);
    }
}
