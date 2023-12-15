package 코드트리.자료구조_중급.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자_등장_횟수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (map.containsKey(a)) {
                map.replace(a, map.getOrDefault(a, 0) + 1);
            } else {
                map.put(a, 1);
            }
        }
        st = new StringTokenizer(br.readLine());
        int tmp;
        for (int i = 0; i < m; i++) {
            tmp = Integer.parseInt(st.nextToken());
            System.out.print(map.getOrDefault(tmp, 0) + " ");
        }
    }
}
