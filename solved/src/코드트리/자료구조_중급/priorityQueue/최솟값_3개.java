package 코드트리.자료구조_중급.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최솟값_3개 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
            if (queue.size() < 3) {
                System.out.println(-1);
            } else {
                long p1 = queue.poll();
                long p2 = queue.poll();
                long p3 = queue.poll();
                System.out.println(p1 * p2 * p3);
                queue.add((int)p1);
                queue.add((int)p2);
                queue.add((int)p3);
            }
        }
    }
}
