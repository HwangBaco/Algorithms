package 코드트리.자료구조_중급.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 배열_추출2 {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Pair> queue = new PriorityQueue<>();
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int q = Integer.parseInt(br.readLine());
            if (q == 0) {
                System.out.println(queue.peek() != null ? queue.poll().plain : 0);
            } else {
                queue.add(new Pair(Math.abs(q), q));
            }
        }

    }

    public static class Pair implements Comparable<Pair>{
        private int abs;
        private int plain;

        public Pair(int abs, int plain) {
            this.abs = abs;
            this.plain = plain;
        }
        @Override
        public int compareTo(Pair pair) {
            if (this.abs == pair.abs) {
                return this.plain - pair.plain;
            }
            return this.abs - pair.abs;
        }
    }
}
