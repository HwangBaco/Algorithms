package 코드트리.자료구조_중급.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최소_정수_출력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            if (v > 0) {
                q.add(v);
            } else {
                System.out.println(q.peek() == null ? 0 : q.poll());
            }
        }
    }
}
