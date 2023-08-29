package 코드트리.자료구조_중급.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class hashmap기본 {
    public static Map<Integer, Integer> m = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a, b;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("add")) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                if (m.containsKey(a)) {
                    m.replace(a, b);
                } else {
                    m.put(a, b);
                }
            } else if (cmd.equals("find")) {
                a = Integer.parseInt(st.nextToken());
                Integer res = m.getOrDefault(a, -1);
                System.out.println(res == -1 ? "None" : res);
            } else if (cmd.equals("remove")) {
                a = Integer.parseInt(st.nextToken());
                m.remove(a);
            }
        }
    }
}
