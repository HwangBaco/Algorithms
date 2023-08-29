package 코드트리.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 쪼개어_배낭_채우기_구현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeSet<Pair> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            set.add(new Pair(w, v));
        }

    }

    public static class Pair implements Comparable<Pair>{
        private int weight;
        private int price;

        public Pair(int weight, int price) {
            this.price = price;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.price == o.price) {
                return o.weight - this.weight;
            }
            return this.price - o.price;
        }
    }
}
