package 코드트리.자료구조_중급.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 친한_점_00기록해라00 {
    private static int n, m;

    public static class Coor implements Comparable<Coor> {
        private int x;
        private int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coor o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        TreeSet<Coor> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(new Coor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Coor higher = set.higher(new Coor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            if (higher != null) {
                System.out.println(higher.x + " " + higher.y);
            } else {
                System.out.println(-1 + " " + -1);
            }
        }

    }
}
