package 코드트리.자료구조_중급.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마지막으로_남은_숫자 {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(-Integer.parseInt(st.nextToken()));
        }
        while (queue.size() >= 2) {
            Integer p1 = -queue.poll();
            Integer p2 = -queue.poll();
            if (p1 != p2) {
                queue.add(-Math.abs(p1 - p2));
            }
        }
        if (queue.size() == 1) {
            System.out.println(-queue.poll());
        } else {
            System.out.println(-1);
        }
    }
}
