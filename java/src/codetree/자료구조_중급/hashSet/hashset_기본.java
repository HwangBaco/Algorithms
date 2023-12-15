package 코드트리.자료구조_중급.hashSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class hashset_기본 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            if (cmd.equals("add")) {
                set.add(a);
            } else if (cmd.equals("find")) {
                System.out.println(set.contains(a));
            } else if (cmd.equals("remove")) {
                set.remove(a);
            }
        }
    }
}
