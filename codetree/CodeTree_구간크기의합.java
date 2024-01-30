package 알고리즘연습.codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class CodeTree_구간크기의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Pair> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            int[] ab = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] ap = new int[]{ab[0], 1};
            int[] bp = new int[]{ab[1], -1};

            Pair a = new Pair(ab[0], 1);
            Pair b = new Pair(ab[1], -1);
            pq.add(a);
            pq.add(b);
        }

        int res = 0;
        int ans = 0;
        int start = 0;
        while (!pq.isEmpty()) {
            Pair now = pq.poll();
            int x = now.x;
            int v = now.v;

            if (res == 0) {
                start = x;
            }
            res += v;
            if (res == 0) {
                ans += now.x - start;
            }
        }
        System.out.println(ans);
    }

    private static class Pair implements Comparable<Pair> {
        private int x, v;

        private Pair(int x, int v) {
            this.x = x;
            this.v = v;
        }

        public int compareTo(Pair p) {
            return this.x - p.x;
        }
    }
}
