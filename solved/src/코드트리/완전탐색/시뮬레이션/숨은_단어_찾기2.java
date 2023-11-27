package 코드트리.완전탐색.시뮬레이션;

import java.io.IOException;

/*

 **/
public class 숨은_단어_찾기2 {
    private static int n = 0;
    private static int[] dx = new int[]
            {
                    0, 1, 1,
                    0, 1, 1,
                    0, 0, 0,
                    0, -1, -1,
                    0, -1, -1,
                    0, -1, -1,
                    0, 0, 0,
                    0, 1, 1,
            };
    private static int[] dy = new int[]
            {
                    0, 0, 0,
                    0, -1, -1,
                    0, -1, -1,
                    0, -1, -1,
                    0, 0, 0,
                    0, 1, 1,
                    0, 1, 1,
                    0, 1, 1,

            };
    public static void main(String[] args) throws IOException {

    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
