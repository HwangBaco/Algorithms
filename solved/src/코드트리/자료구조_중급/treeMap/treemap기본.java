package 코드트리.자료구조_중급.treeMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class treemap기본 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new TreeMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("add")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (map.containsKey(a)) {
                    map.replace(a, b);
                } else {
                    map.put(a, b);
                }
            } else if (cmd.equals("find")) {
                int a = Integer.parseInt(st.nextToken());
                System.out.println(map.containsKey(a) ? map.get(a) : "None");
            } else if (cmd.equals("remove")) {
                int a = Integer.parseInt(st.nextToken());
                map.remove(a);
            } else if (cmd.equals("print_list")) {
                if (map.isEmpty()) {
                    System.out.println("None");
                } else {
                    for (Integer idx : map.keySet()) {
                        System.out.print(map.get(idx) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
