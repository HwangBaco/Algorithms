package 코드트리.시뮬레이션.dxdy테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 빙빙_돌며_숫자_적기 {
    public static int[][] arr;
    public static int[][] visited;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static int n, m, dir, num, x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dir = 0;
        num = 1;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new int[n][m];

        x = 0;
        y = 0;
        while (true) {
            arr[y][x] = num++;
            visited[y][x] = 1;
            if (num == n * m + 1) {
                break;
            }
            if (inRange(x + dx[dir], y + dy[dir], visited)) {
                x += dx[dir];
                y += dy[dir];
            } else {
                dir = (dir + 1) % 4;
                x += dx[dir];
                y += dy[dir];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean inRange(int x, int y, int[][] visited) {
        return (x >= 0 && x < m && y >= 0 && y < n && visited[y][x] != 1);
    }
}
