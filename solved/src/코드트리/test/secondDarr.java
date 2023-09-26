package 코드트리.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class secondDarr {
    private static int[] dx = new int[]{0, -1, 0, 1};
    private static int[] dy = new int[]{1, 0, -1, 0};
    private static int[][] arr;
    private static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        int curX = 0;
        int curY = 0;
        int curDir = 0;
        for (int i = 0; i < k; i++) {
            String cmd = br.readLine();
            if (cmd.equals("F")) {
                curX = curX + dx[curDir];
                curY = curY + dy[curDir];
                ans += arr[curY][curX];
            } else if (cmd.equals("R")) {
                curDir = (curDir+1) % 4;
            }
        }
        System.out.println(ans);

    }
}
