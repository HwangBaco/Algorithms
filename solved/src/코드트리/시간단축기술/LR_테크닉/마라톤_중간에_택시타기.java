package 코드트리.시간단축기술.LR_테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마라톤_중간에_택시타기 {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;
        Pair[] arr = new Pair[n];
        int[] LSum = new int[n];
        int[] RSum = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int _x = Integer.parseInt(st.nextToken());
            int _y = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(_x, _y);

        }
        for (int i = 1; i < n; i++) {
            LSum[i] = LSum[i - 1] + Math.abs(arr[i].x - arr[i - 1].x) + Math.abs(arr[i].y - arr[i - 1].y);
            RSum[i] = RSum[i - 1] + Math.abs(arr[n - i].x - arr[n - i - 1].x) + Math.abs(arr[n - i].y - arr[n - i - 1].y);
            System.out.println("LSum = " + LSum[i]);
            System.out.println("RSum = " + RSum[i]);
        }
        for (int i = 1; i < n-1; i++) {
            int res = LSum[i-1] + RSum[n - i- 2] + Math.abs(arr[i - 1].x - arr[i + 1].x) + Math.abs(arr[i - 1].y - arr[i + 1].y);
            System.out.println("res = " + res);
            System.out.println("arr[i-1].x = " + arr[i - 1].x);
            System.out.println("arr[i-1].y = " + arr[i - 1].y);
            System.out.println("arr[i+1].x = " + arr[i + 1].x);
            System.out.println("arr[i+1].y = " + arr[i + 1].y);
            ans = Math.min(ans, res);
        }
        System.out.println(ans);

    }

    public static class Pair implements Comparable<Pair>{
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }


}
