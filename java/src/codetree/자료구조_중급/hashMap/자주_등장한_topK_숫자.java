package 코드트리.자료구조_중급.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.HashMap;
import java.util.stream.Collectors;

public class 자주_등장한_topK_숫자 {
    private static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.putIfAbsent(key, 0);
            map.replace(key, map.get(key) + 1); // 등장횟수 체크
        }
        List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (cnt == k) {
                break;
            }
            cnt++;
            System.out.print(entry.getKey() + " ");
        }
    }
}
