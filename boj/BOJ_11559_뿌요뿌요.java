package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11559_뿌요뿌요 {
    public static final int HEIGHT = 12;
    public static final int WIDTH = 6;
    private static int[] visited = new int[HEIGHT];
    private static String[][] grid = new String[HEIGHT][WIDTH];
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    private static boolean isBomb;
    private static boolean hasChain;
    private static int depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < HEIGHT; i++) {
            String s = br.readLine();
            for (int j = 0; j < WIDTH; j++) {
                grid[i][j] = s.substring(j, j + 1);
            }
        }
        int chainCnt = 0;
        while (true) {

            visited = new int[HEIGHT];
            // 터뜨리기
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    if (!grid[i][j].equals(".") && (visited[i] & 1 << j) == 0) {
                        // dfs 돌입 전 터지는 여부 초기화
                        isBomb = false;
                        depth = 0;
                        dfs(i, j, grid[i][j]);
                    }
                }
            }
            for (int i = 0; i < WIDTH; i++) {
                String[] temp = new String[HEIGHT]; // 중력 업데이트용
                // 현황 체크
                int tempIdx = 0;
                for (int j = HEIGHT - 1; j >= 0; j--) {
                    if (!grid[j][i].equals(".")) {
                        temp[tempIdx++] = grid[j][i];
                    }
                }
                // 중력 반영
                int idx = 0;
                for (int j = HEIGHT - 1; j >= 0; j--) {
                    grid[j][i] = temp[idx] == null ? "." : temp[idx];
                    idx++;
                }
            }
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    System.out.print(grid[i][j]);

                }
                System.out.println();

            }
            System.out.println("=================");

            if (!hasChain) {
                System.out.println("END");
                break;
            }


            hasChain = false;
            chainCnt++;

        }
        System.out.println(chainCnt);

    }

    private static void dfs(int y, int x, String color) {
        if (depth >= 4) {
            isBomb = true;
            hasChain = true;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (canGo(ny, nx, color)) {
                depth++;
                visited[ny] |= 1 << nx;
                dfs(ny, nx, color);
            }
        }
        // 상하좌우로 연결된 개수가 4 이상인 경우 전부 터뜨림.
        if (isBomb) {
            grid[y][x] = ".";
        }
    }

    private static boolean canGo(int y, int x, String color) {
        return inRange(y, x) && (visited[y] & 1 << x) == 0 && grid[y][x].equals(color);
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < HEIGHT && x >= 0 && x < WIDTH;
    }
}
