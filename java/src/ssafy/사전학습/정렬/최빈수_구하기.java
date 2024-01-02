package ssafy.사전학습.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최빈수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> m = new HashMap<>();
            for (int j = 0; j < 1000; j++) {
                int num = Integer.parseInt(st.nextToken());
                m.putIfAbsent(num, 0);
                m.replace(num, m.get(num) + 1);
            }
            ArrayList<Integer> keys = new ArrayList<>(m.keySet());
            keys.sort((o1, o2) -> {
                if (m.get(o2).equals(m.get(o1))) {
                    return o2.compareTo(o1);
                }
                return m.get(o2).compareTo(m.get(o1));
            });
            System.out.println("#" + i + " " + keys.get(0));
        }
    }
}
