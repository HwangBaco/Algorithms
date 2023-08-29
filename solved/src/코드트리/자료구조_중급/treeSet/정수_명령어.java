package 코드트리.자료구조_중급.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 정수_명령어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            set = new TreeSet<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int v = Integer.parseInt(st.nextToken());
                if (cmd.equals("I")) {
                    set.add(v);
                } else {
                    if (!set.isEmpty() && v == 1) {
                        set.remove(set.last());
                    } else if (!set.isEmpty() && v == -1) {
                        set.remove(set.first());
                    }
                }
            }
            if (set.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(set.last() + " " + set.first());
            }
        }

    }
}
