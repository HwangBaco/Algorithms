package 코드트리.시뮬레이션.dxdy테크닉;

public class 격자dxdy {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 0}
        };

        int x = 2, y = 4;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int cnt = 0;
        for (int dir = 0; dir < 4; dir++) {
            if (inRange(x + dx[dir], y + dy[dir])
                    && arr[y + dy[dir]][x + dx[dir]] == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean inRange(int x, int y) {
        return (0 <= x && x <= 4 && 0 <= y && y <= 4);
    }
}
