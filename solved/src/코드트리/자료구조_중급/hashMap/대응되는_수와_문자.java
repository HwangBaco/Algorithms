package 코드트리.자료구조_중급.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 대응되는_수와_문자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 숫자의 개수
        int m = Integer.parseInt(st.nextToken()); // 조사할 값의 개수
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String key = br.readLine();
            map1.put(key, i);
            map2.put(i, key);
        }
        for (int i = 0; i < m; i++) {
            String q = br.readLine();
            if (map1.containsKey(q)) {
                System.out.println(map1.get(q));
            } else {
                System.out.println(map2.get(Integer.parseInt(q)));
            }
        }
    }
}
