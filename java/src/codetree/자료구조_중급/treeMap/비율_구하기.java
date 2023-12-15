package 코드트리.자료구조_중급.treeMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 비율_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Map<String, Double> map = new TreeMap<>();
        String s;
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            map.putIfAbsent(s, (double) 0);
            map.replace(s, map.get(s) + 1);
        }
        for (String sidx : map.keySet()) {
            map.replace(sidx, map.get(sidx) / n * 100);
            System.out.printf("%s %.4f\n",sidx, map.get(sidx));
        }

    }
}
