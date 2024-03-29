package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3055_탈출 {
    private static boolean[] visited;
    private static long[][] map1;
    private static long[][] map2;
    private static int R, C, startY, startX, destY, destX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map1 = new long[R][C];
        map2 = new long[R][C];
        visited = new boolean[R];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                if (c == 'S') {
                    startY = i;
                    startX = j;
                }
            }
        }
    }
}
