package 코드트리.시뮬레이션.dxdy테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이동경로상에_있는_모든_숫자_더하기 {
    public static int n, dir, x, y, ans, t;
    public static int[][] arr;
    public static int[] dx = new int[]{1, 0, -1, 0}; // E S W N
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String command = st.nextToken();
        dir = 3;
        arr = new int[n][n];
        // 배열 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        x = n / 2;
        y = n / 2;

        ans += arr[y][x];
        boolean flag = false;
        for (int i = 0; i < t; i++) {
            String s = command.substring(i, i + 1);
            doCommand(s);
            if (inRange(x, y) && s.equals("F")) {
                ans += arr[y][x];
            } else if (!inRange(x, y)) {
                System.out.println(ans);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(ans);
        }
    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void doCommand(String s) {
        if (s.equals("F")) {
            x += dx[dir];
            y += dy[dir];
        } else if (s.equals("R")) {
            dir = (dir + 1) % 4;
        } else if (s.equals("L")) {
            dir = (dir - 1 + 4) % 4;
        }
    }
}
