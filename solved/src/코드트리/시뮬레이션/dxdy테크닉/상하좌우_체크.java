package 코드트리.시뮬레이션.dxdy테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상하좌우_체크 {
    public static int[][] arr;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};
    public static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        int r, c, cnt;

        /*
        for i in range(m):
            (r,c) 주어지면 해당 칸 색칠
            if (isComfort(arr[i][j])): print(1) else print(0)
        **/
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken())-1;
            arr[r][c] = 1;
            cnt = 0;
            for (int j = 0; j < 4; j++) {
                if (inRange(c+dx[j],r+dy[j]) && arr[r + dy[j]][c + dx[j]] == 1) {
                    cnt++;
                }
            }
            if (cnt == 3) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
}
