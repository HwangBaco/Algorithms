package 코드트리.shortenTimeSkill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prefix_sum_basic {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] sum = new int[n+1];
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i+1] = arr[i] + sum[i];
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (inRange(i + k)) {
                queue.add(-(sum[i + k] - sum[i]));
            }
        }
        System.out.println(-queue.poll());
    }

    private static boolean inRange(int k) {
        return k < n;
    }
}
