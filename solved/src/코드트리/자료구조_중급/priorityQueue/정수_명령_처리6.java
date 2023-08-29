package 코드트리.자료구조_중급.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정수_명령_처리6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                int v = Integer.parseInt(st.nextToken());
                q.add(-v);
            } else if (cmd.equals("size")) {
                System.out.println(q.size());
            } else if (cmd.equals("empty")) {
                System.out.println(q.isEmpty() ? 1 : 0);
            } else if (cmd.equals("pop")) {
                System.out.println(-q.poll());
            } else if (cmd.equals("top")) {
                System.out.println(-q.peek());
            }
        }
    }
}
