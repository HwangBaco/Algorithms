package 코드트리.자료구조_중급.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 배열_추출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == 0) {
                System.out.println(queue.size() == 0 ? 0 : -queue.poll());
            } else {
                queue.add(-cmd);
            }
        }
    }
}
