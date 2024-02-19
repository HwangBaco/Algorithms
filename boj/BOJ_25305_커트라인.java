package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_25305_커트라인 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(-Integer.parseInt(st.nextToken()));
        }
        int num = 0;
        for (int i = 0; i < k; i++) {
            num = pq.poll();
        }
        System.out.println(-num);
    }
}
