package 알고리즘연습.boj;

import java.io.*;
import java.util.*;

/**
 * @intuition bruteforce
 * @algorithm bruteforce
 * @time O(N^4) : 먹이 탐색 O(N^2) * 먹으러 가기 O(N^2)
 * @memory O(N^2)
 */
public class 풀고있음_BOJ_16236_아기상어 {
    private static int N;
    private static int[][] map;
    private static int[] shark;
    private static boolean[][] visited;
    private static PriorityQueue<int[]> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new int[]{i, j};
                }
            }
        }



        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
//    private static boolean searchTargets(int sharkSize) {
//        pq = new PriorityQueue<>((o1, o2) -> {
//            if (o1[2] == o2[2]) { // 거리 동일하면
//                return o1[1] - o2[1]; // x좌표 순
//            }
//            return o1[2] - o2[2]; // 거리 짧은 순
//        });
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (map[i][j] > 0 && map[i][j] < sharkSize) {
//
//                }
//            }
//        }
//
//    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }

//    private static boolean canGo(int y, int x) {
//        return inRange(y, x) &&
//    }
}
