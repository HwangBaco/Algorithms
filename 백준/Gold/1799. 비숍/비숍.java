import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] grid;
    private static boolean[] left, right;
    private static int[] ans = new int[2];
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        left = new boolean[N << 1];
        right = new boolean[N << 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, 0, 0, 0);
        go(0, 1, 0, 1);
        System.out.println(ans[0] + ans[1]);
    }

    private static void go(int y, int x, int cnt, int color) {
        if (x >= N) {
            y++;
            x = (x % 2 == 0) ? 1 : 0;
        }
        if (y >= N) {
            ans[color] = Math.max(ans[color], cnt);
            return;
        }
        if (grid[y][x] == 1 && !left[y - x + N - 1] && !right[x + y]) {
            left[y - x + N - 1] = true;
            right[x + y] = true;
            go(y, x + 2, cnt + 1, color);
            left[y - x + N - 1] = false;
            right[x + y] = false;
        }
        go(y, x + 2, cnt, color);
    }
}