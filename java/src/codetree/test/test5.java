package 코드트리.진단테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test5 {
    public static int[] dx = new int[]{0, -1, 0, 1};
    public static int[] dy = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        int x = 0;
        int y = 0;
        int Xdir = 0;
        int Ydir = 0;
        for (int i = 0; i < k; i++) {
            String cmd = br.readLine();
            if (cmd.equals("F")) {
                x += dx[Xdir];
                y += dy[Ydir];
                arr[y][x] += 1;
            } else {
                Xdir = (Xdir + 1) % 4;
                Ydir = (Ydir + 1) % 4;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
