package 코드트리.자료구조_중급.hashSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 대칭_차집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int e = Integer.parseInt(st.nextToken());
            countElem(map, e);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int e = Integer.parseInt(st.nextToken());
            countElem(map, e);
        }
        int ans = 0;
        for (Integer v : map.values()) {
            if (v == 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static void countElem(Map<Integer, Integer> map, int e) {
        if (map.containsKey(e)) {
            map.replace(e, map.get(e) + 1);
        } else {
            map.put(e, 1);
        }
    }
}
