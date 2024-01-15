package ssafy.과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사과나무_영양분_구하기 {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                arr[j][k] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = Integer.MIN_VALUE;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int res = arr[y][x];
                for (int j = 0; j < 4; j++) {
                    int newY = y + dy[j];
                    int newX = x + dx[j];
                    if (inRange(newY, newX)) {
                        res += arr[newY][newX];
                    }
                }
                ans = Math.max(ans, res);
            }
        }
        System.out.println(ans);
    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
