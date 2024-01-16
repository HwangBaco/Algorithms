package 코드트리.자료구조_중급.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 가장_가까운_점 {
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Pair> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < m; i++) {
            Pair poll = queue.poll();
            poll.x += 2;
            poll.y += 2;
            queue.add(poll);
        }
        Pair ans = queue.poll();
        System.out.println(ans.x + " " + ans.y);

    }

    public static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair pair) {
            if ((Math.abs(this.x) + Math.abs(this.y)) == (Math.abs(pair.x) + Math.abs(pair.y))) {
                if (this.x == pair.x) {
                    return this.y - pair.y;
                }
                return this.x - pair.x;
            }
            return (Math.abs(this.x) + Math.abs(this.y)) - (Math.abs(pair.x) + Math.abs(pair.y));
        }
    }


}
