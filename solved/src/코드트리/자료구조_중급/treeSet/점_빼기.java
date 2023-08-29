package 코드트리.자료구조_중급.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 점_빼기 {
    /*
    점들이 주어지면 저장해둬야 한다.
    k가 주어지면, 좌표의 x값이 k보다 큰 점 중에서 x와 y가 가장 작은 점을 출력하고 지운다.
    -> treeset에 넣어두고, higher(k)를 활용하여 답을 도출해냄. 동점자중 y가 작은 애는
    -> 트리셋에서 알아서 반환해줌
    **/
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Pair> set = new TreeSet<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            set.add(new Pair(x, y));
        }
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(br.readLine());
            Pair ans = set.higher(new Pair(k, 0));
            if (ans != null) {
                System.out.println(ans.getX() + " " + ans.getY());
                set.remove(ans);
            } else {
                System.out.println(-1 + " " + -1);
            }

        }

    }

    public static class Pair implements Comparable<Pair> {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }

    }

}
