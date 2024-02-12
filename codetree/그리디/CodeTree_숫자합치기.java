package 알고리즘연습.codetree.그리디;

import java.io.*;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class CodeTree_숫자합치기 {
    /*
    * 수행시간 : 678 ms
    *
    * 메모리 : 27 MB
    *
    * 시간복잡도 : O(N * logN)
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int ans = solution(n, arr);

        bw.write(String.valueOf(ans));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int solution(int n, int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }

        int ans = 0;
        while (pq.size() >= 2) {
            Integer a = pq.poll();
            Integer b = pq.poll();
            ans += (a + b);
            pq.add(a + b);
        }

        return ans;
    }
}
