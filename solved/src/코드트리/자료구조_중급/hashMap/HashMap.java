package 코드트리.자료구조_중급.hashMap;

import java.io.IOException;
import java.util.Map;

public class HashMap {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> m = new java.util.HashMap<>();
        m.put(5, 6);
        m.put(2, 2);
        m.put(10, 1);

        if (m.containsKey(2)) {
            System.out.println(m.get(2));
        }

        m.remove(5);

        if (!m.containsKey(5)) {
            System.out.println("not exists");
        }

        m.put(2, 10);
        System.out.println(m.get(2));

        System.out.println(m.getOrDefault(99, -1));
    }
}
