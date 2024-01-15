package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17136 {
    private static int[] amount = {0, 5, 5, 5, 5, 5};
    public static void main(String[] args) throws IOException {
        // 그리디?
        /*
        * 배열을 입력받는다.
        * 입력받을 때 1이 있는 위치는 모두 List<pair>로 저장해둔다.
        *
        * 사이즈 5..1순으로 루프 {
        *   배열을 전체 탐색한다.
        *   사이즈가 맞는지 검사
        *       사이즈가 맞으면 && amount 남아있으면 -> visited = true; && amount[size]--; ans++;
        *
        *
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] board = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }




    }

    public static class Pair {
        int x, y;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
