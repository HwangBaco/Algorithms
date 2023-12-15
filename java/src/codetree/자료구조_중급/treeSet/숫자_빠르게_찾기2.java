package 코드트리.자료구조_중급.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 숫자_빠르게_찾기2 {
    private static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int e;
        for (int i = 0; i < m; i++) {
            e = Integer.parseInt(br.readLine());
            if (set.ceiling(e) != null) {
                System.out.println(set.ceiling(e));
            } else {
                System.out.println(-1);
            }
        }
    }
}
