package 코드트리.자료구조_중급.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class treeset_기본 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String cmd;
        TreeSet<Integer> set = new TreeSet<>();
        int a;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            if (cmd.equals("add")) {
                a = Integer.parseInt(st.nextToken());
                set.add(a);

            } else if (cmd.equals("remove")) {
                a = Integer.parseInt(st.nextToken());
                set.remove(a);

            } else if (cmd.equals("find")) {
                a = Integer.parseInt(st.nextToken());
                System.out.println(set.contains(a));

            } else if (cmd.equals("lower_bound")) {
                a = Integer.parseInt(st.nextToken());
                System.out.println(set.ceiling(a) == null ? "None" : set.ceiling(a));

            } else if (cmd.equals("upper_bound")) {
                a = Integer.parseInt(st.nextToken());
                System.out.println(set.higher(a) == null ? "None" : set.higher(a));

            } else if (cmd.equals("largest")) {
                System.out.println(set.isEmpty() ? "None" : set.last());

            } else if (cmd.equals("smallest")) {
                System.out.println(set.isEmpty() ? "None" : set.first());
            }
        }
    }
}
