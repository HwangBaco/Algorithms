package 코드트리.자료구조_중급.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 낮은_지점들 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int x, y;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (map.containsKey(x)) {
                replaceSmallerValue(x, y, map);
            } else {
                map.put(x, y);
            }
        }
        long ans = 0;
        for (Integer value : map.values()) {
            ans += value;
        }
        System.out.println(ans);
    }

    private static void replaceSmallerValue(int x, int y, Map<Integer, Integer> map) {
        if (y < map.get(x)) {
            map.replace(x, y);
        }
    }
}
