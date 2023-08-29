package 코드트리.자료구조_중급.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 순서를_바꾸었을때_같은단어_그룹화하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s;
        Map<String, Integer> map = new HashMap<>();
        /*
        단어를 받는다.
        단어를 정렬한다.
        각 단어를 HashMap에 카운트한다.
        value를 내림차순 정렬한다.
        맨 앞의 숫자를 출력한다.
        **/

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            s = Stream.of(s.split(""))
                    .sorted()
                    .collect(Collectors.joining());
            if (map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        List<Map.Entry<String, Integer>> entries = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getValue());
            break;
        }
    }
}
