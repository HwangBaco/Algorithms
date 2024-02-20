package 알고리즘연습.boj;

import java.io.*;
import java.util.*;

/**
 * @author 황제철
 *
 * 유형 : 다이나믹 프로그래밍
 * dp[n] : n번 칸에 도달할 수 있는 최소 주사위 roll 횟수
 */
public class BOJ_16928_뱀과사다리게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] ladders = new int[n][2];
        int[][] sneaks = new int[m][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ladders[i][0] = Integer.parseInt(st.nextToken());
            ladders[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            sneaks[i][0] = Integer.parseInt(st.nextToken());
            sneaks[i][1] = Integer.parseInt(st.nextToken());
        }

        int ans = solution(ladders, sneaks);

        bw.write(String.valueOf(ans));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int solution(int[][] ladders, int[][] sneaks) {


        return -1;
    }

//    public static void main(String[] args) throws IOException {
//        // dp 초기화
//        int[] dp = new int[101];
//        dp[0] = 0;
//        dp[1] = 0;
//        int rollCnt = 1;
//        for (int i = 2; i <= 100; i++) {
//            dp[i] = rollCnt;
//            if ((i - 1) % 6 == 0) {
//                rollCnt++;
//            }
//        }
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        List<int[]> ladders = new ArrayList<>();
//        List<int[]> sneaks = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//            ladders.add(new int[]{start, end});
//        }
//
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//            sneaks.add(new int[]{start, end});
//        }
//
//
//        for (int[] ladder : ladders) {
//            int start = ladder[0];
//            int end = ladder[1];
//            int temp = dp[start];
//            int loopCnt = -1;
//            rollCnt = 1;
//            for (int j = end; j <= 100; j++) {
//                loopCnt++;
//                dp[j] = Math.min(dp[j], temp + rollCnt);
//                if (loopCnt != 0 && loopCnt % 6 == 0) {
//                    rollCnt++;
//                }
//            }
//        }
//        for (int[] sneak : sneaks) {
//            int start = sneak[0];
//            int end = sneak[1];
//            int temp = dp[start];
//            int loopCnt = -1;
//            rollCnt = 1;
//            for (int j = end; j <= 100; j++) {
//                loopCnt++;
//                dp[j] = Math.min(dp[j], temp + rollCnt);
//                if (loopCnt != 0 && loopCnt % 6 == 0) {
//                    rollCnt++;
//                }
//            }
//        }
//        for (int[] ladder : ladders) {
//            int start = ladder[0];
//            int end = ladder[1];
//            int temp = dp[start];
//            int loopCnt = -1;
//            rollCnt = 1;
//            for (int j = end; j <= 100; j++) {
//                loopCnt++;
//                dp[j] = Math.min(dp[j], temp + rollCnt);
//                if (loopCnt != 0 && loopCnt % 6 == 0) {
//                    rollCnt++;
//                }
//            }
//        }
//        for (int[] sneak : sneaks) {
//            int start = sneak[0];
//            int end = sneak[1];
//            int temp = dp[start];
//            int loopCnt = -1;
//            rollCnt = 1;
//            for (int j = end; j <= 100; j++) {
//                loopCnt++;
//                dp[j] = Math.min(dp[j], temp + rollCnt);
//                if (loopCnt != 0 && loopCnt % 6 == 0) {
//                    rollCnt++;
//                }
//            }
//        }
//
////        for (int i = 1; i <= 100; i++) {
////            System.out.print(dp[i] + " ");
////            if (i % 10 == 0) {
////                System.out.println();
////            }
////        }
//
//        System.out.println(dp[100]);
//    }
}
