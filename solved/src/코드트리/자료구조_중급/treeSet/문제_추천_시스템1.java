package 코드트리.자료구조_중급.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 문제_추천_시스템1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        TreeSet<Pair> set = new TreeSet<>();
        // rc 1 : 난이도 가장 높은 문제 번호 출력, 여러개라면 문제 번호가 큰 것 출력
        // rc -1 : 난이도 가장 낮은 문제 번호 출력, 여러개라면 문제 번호가 작은 것 출력
        // -> rc는 NPE 예외처리 경우 없음
        // ad P L : 난이도가 L인 문제 번호 P 추가
        // sv P L : 난이도가 L인 문제 번호 P 제거
        // -> sv는 NPR 예외처리 경우 없음

        /* 문제 입력 */
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("rc")) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) {
                    System.out.println(set.last().p);
                } else {
                    System.out.println(set.first().p);
                }
            } else if (cmd.equals("ad")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                set.add(new Pair(p, l));
            } else {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                set.remove(new Pair(p, l));
            }
        }
    }

    public static class Pair implements Comparable<Pair>{
        private int p;
        private int l;
        public int getP() {
            return this.p; // 문제번호
        }

        public int getL() {
            return this.l; // 난이도
        }

        public Pair(int p, int l) {
            this.p = p;
            this.l = l;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.l == pair.l) {
                return this.p - pair.p;
            }
            return this.l - pair.l;
        }

    }
}
