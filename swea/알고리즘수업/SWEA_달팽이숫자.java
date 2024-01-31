package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_달팽이숫자 {
    private static int n;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            visited = new boolean[n][n];
            int vectorIdx = 0;

            arr[0][0] = 1;
            visited[0][0] = true;

            go(0, 0, dy[vectorIdx], dx[vectorIdx], vectorIdx, 2);

            System.out.printf("#%d\n", tc);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }




    }

    private static void go(int y, int x, int yVector, int xVector, int vectorIdx, int depth) {
        if (depth == n * n + 1) {
            return;
        }
        // 진행방향대로 진행 시도
        int ny = y + yVector;
        int nx = x + xVector;

        // 만약 꺾어야 하면 꺾어서
        if (!inRange(ny, nx) || visited[ny][nx]) {
            vectorIdx = (vectorIdx + 1) % 4;
            yVector = dy[vectorIdx];
            xVector = dx[vectorIdx];
            ny = y + yVector;
            nx = x + xVector;
        }

        arr[ny][nx] = depth;
        visited[ny][nx] = true;
        go(ny, nx, yVector, xVector, vectorIdx, depth + 1);


    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
