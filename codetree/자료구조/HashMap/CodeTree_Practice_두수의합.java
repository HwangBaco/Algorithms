package 알고리즘연습.codetree.자료구조.HashMap;

import java.io.*;
import java.util.*;

/**
 * 결국 경우의 수 문제
 * 내가 알아야 하는 건, 해당 숫자가 몇 개씩 있는가?
 *
 * 맵에 <key : value = 숫자 : 개수> 넣어두고, keySet() 순회하면서 경우의 수 세주고, visited 관리해서 pass 할 거 패스해주자.
 * 이 때, 주어지는 숫자의 범위가 20억이므로 배열로 visited 관리가 불가능. 따라서 visited를 map으로 관리해주자.
 */
public class CodeTree_Practice_두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1); // 개수 먼저 count
            visited.put(key, false);
        }

        int ans = 0;
        for (Integer key : map.keySet()) {
            if (!visited.getOrDefault(key, true) && !visited.getOrDefault(k - key, true)) {
                int a = map.getOrDefault(key, 0);
                int b = map.getOrDefault(k - key, 0);
                if (key != k - key) {
                    ans += a * b;
                } else {
                    ans += a * (a - 1) / 2;
                }
                visited.put(key, true);
                visited.put(k- key, true);
            }
        }
        System.out.println(ans);
    }
}
