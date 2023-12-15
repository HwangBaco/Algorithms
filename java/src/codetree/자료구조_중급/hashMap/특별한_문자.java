package 코드트리.자료구조_중급.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.HashMap;
import java.util.stream.Collectors;

public class 특별한_문자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        Map<String, Integer> map = new HashMap<>();
        for (String e : s.split("")) {
            map.putIfAbsent(e, 0);
            map.replace(e, map.get(e) + 1);
        }
        List<Map.Entry<String, Integer>> entries = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() > 1) {
                System.out.println("None");
            } else if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
            break;
        }
    }
}
