package 코드트리.완전탐색.forLoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최고의33위치 {
    private static int n;
    private static int[][] arr;
    private static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n-2; j++) {
                int res = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        res += arr[i+k][j+l];
                    }
                }
                pq.add(-res);
//                max = Math.max(max, res);
            }
        }
//        System.out.println(max);
        System.out.println(-pq.poll());

    }

}
