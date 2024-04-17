package 알고리즘연습.boj;

import java.io.*;
import java.util.*;

public class BOJ_보석도둑 {
    static int[] bags;
    private static int N, K, M, V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] jewels = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            jewels[i] = new int[]{M, V};
        }
        Arrays.sort(jewels, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        long ans = 0;
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int bag : bags) {
            while (i < N) {
                if (jewels[i][0] <= bag) {
                    pq.add(jewels[i++][1]);
                } else if (jewels[i][0] > bag){
                    break;
                }
            }
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        System.out.println(ans);
    }
}
