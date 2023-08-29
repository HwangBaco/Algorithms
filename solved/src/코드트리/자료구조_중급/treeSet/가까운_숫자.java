package 코드트리.자료구조_중급.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 가까운_숫자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> dist = new TreeSet<>();
        set.add(0); // init

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int q = Integer.parseInt(st.nextToken());
            set.add(q);
            if (set.lower(q) != null) {
                dist.add(q - set.lower(q));
            }
            if (set.higher(q) != null) {
                dist.add(set.higher(q) - q);
            }
            if (dist.first() != null) {
                System.out.println(dist.first());
            }
        }


    }
}
