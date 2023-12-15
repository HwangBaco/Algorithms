package 코드트리.자료구조_중급.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 최대_숫자_구하기 {
    private static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= m; i++) {
            set.add(i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int q = Integer.parseInt(st.nextToken());
            set.remove(q);
            System.out.println(set.last());

        }
    }
}
