package 알고리즘연습.codetree.legacy;

import java.io.IOException;
import java.util.*;

public class CodeTree_최소와이파이수 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> m = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        hs.add("Hello");
        hs.add("world");

        TreeSet<String> ts = new TreeSet<>();

        Iterator<String> iterator = hs.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("world")) {
                iterator.remove();
            }
        }
        for (String h : hs) {
            if (h.equals("Hello")) {
                hs.remove(h);
            }
        }
        for (String h : hs) {
            System.out.println(h);
        }

        HashMap<String, Integer> hm = new HashMap<>();
        Set<String> strings = hm.keySet();
        hm.put("hello", 1);
        Iterator<String> iterator1 = strings.iterator();
        while (iterator1.hasNext()) {
            String next = iterator1.next();
            iterator1.remove();
        }
        for (String string : strings) {
            System.out.println(string);
        }
        List<Integer> li = new ArrayList<>();
//        li.sort();
    }
}
