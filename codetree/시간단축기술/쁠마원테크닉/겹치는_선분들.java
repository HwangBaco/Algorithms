package 코드트리.시간단축기술.쁠마원테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class 겹치는_선분들 {
    private static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int crtIdx = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            String cmd = st.nextToken();
            if (cmd.equals("R")) {
                map.putIfAbsent(crtIdx, 0);
                map.replace(crtIdx, map.get(crtIdx) + 1);
                crtIdx += v;
                map.putIfAbsent(crtIdx, 0);
                map.replace(crtIdx, map.get(crtIdx) - 1);
            } else {
                map.putIfAbsent(crtIdx, 0);
                map.replace(crtIdx, map.get(crtIdx) - 1);
                crtIdx -= v;
                map.putIfAbsent(crtIdx, 0);
                map.replace(crtIdx, map.get(crtIdx) + 1);
            }
        }
        long cnt = 0;
        long ans = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer key : map.keySet()) {
            cnt += map.get(key);
//            System.out.print("key = " + key);
//            System.out.println(", cnt = " + cnt);
            if (cnt >= k) {
                set.add(key);
            } else if (set.size() > 0 && cnt < k) {
                set.add(key);
                ans += Math.abs(set.first() - set.last());
                set = new TreeSet<>();
            }
            if (key == map.lastKey() && set.size() > 0) {
                set.add(key);
                ans += Math.abs(set.first() - set.last());
            }
        }
        System.out.println(ans);
    }
}
