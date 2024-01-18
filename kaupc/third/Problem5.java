package kaupc.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem5 {
    static final int X_SIZE = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> m = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            m.put(i, Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                for (int j = 1; j <= X_SIZE; j++) {
                    if (m.containsValue(j) && (val % j) == 0 && m.containsValue(val / j)) {
                        System.out.println("ans : " + 1);
                        break;
                    } else if (j == X_SIZE) {
                        System.out.println("ans : " + 0);
                    }
                }
            } else {
                m.replace(val, 0);
                System.out.println("-----------");
                for (Integer value : m.values()) {
                    System.out.println(value);
                }
                System.out.println("-----------");
            }
        }
    }
}
