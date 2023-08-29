package 코드트리.시뮬레이션.dxdy테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거울에_레이저_쏘기2 {
    public static int[] dx = new int[]{0, 1, 0, -1}; // '/'
    public static int[] dy = new int[]{-1, 0, 1, 0}; // '/'
    public static int[] _dx = new int[]{0, 1, 0, -1}; // '\'
    public static int[] _dy = new int[]{1, 0, -1, 0}; // '\'
    public static int n, x, y;
    public static String dir;
    public static String[][] arr;
    public static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        1. n * n 행렬
        2. 레이저를 쐈을 때,
        /면 -> 위에서 쏘면 왼쪽으로, 왼쪽에서 쏘면 위로,
              아래서 쏘면 오른쪽으로, 오른쪽에서 쏘면 아래로.
        \면 -> 위에서 쏘면 오른쪽으로, 오른쪽에서 쏘면 위로,
              아래서 쏘면 왼쪽으로, 왼쪽에서 쏘면 아래로.

        x,y이동하면서
        mirror[y][x] == /인지 \인지 확인하고
        /이면 x,y를 위 규칙대로 한칸 이동 && ans++;
        \이면 x,y를 위 규칙대로 한칸 이동 && ans++;
        x 또는 y가 격자를 벗어났을 때 print(ans)
        **/
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        // 격자 배열에 거울 입력
        arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.substring(j,j+1);
            }
        }
        int target = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        starter(target);
        reflect(arr, x, y, dir);

    }

    public static void starter(int target) {
        int facade = (target-1) / n;
//        System.out.println("facade = " + facade);
        int idx = (target-1) % n;
//        System.out.println("idx = " + idx);
        if (facade == 0) {
            y = 0;
            x = idx;
            dir = "S";
        } else if (facade == 1) {
            x = n-1;
            y = idx;
            dir = "W";
        } else if (facade == 2) {
            y = n-1;
            x = n - idx - 1;
            dir = "N";
        } else if (facade == 3) {
            x = 0;
            y = n - idx - 1;
            dir = "E";
        }
    }

    public static void reflect(String[][] arr, int x, int y, String dir) {
        if (arr[y][x].equals("/")) {
            if (dir.equals("S")) {
                y = y + dy[3];
                x = x + dx[3];
                dir = "W";
                ans++;
            } else if (dir.equals("E")) {
                y = y + dy[0];
                x = x + dx[0];
                dir = "N";
                ans++;
            } else if (dir.equals("W")) {
                y = y + dy[2];
                x = x + dx[2];
                dir = "S";
                ans++;
            } else if (dir.equals("N")) {
                y = y + dy[1];
                x = x + dx[1];
                dir = "E";
                ans++;
            }
        } else { // '\' 인 경우
            if (dir.equals("S")) {
                y = y + _dy[1];
                x = x + _dx[1];
                dir = "E";
                ans++;
            } else if (dir.equals("E")) {
                y = y + _dy[0];
                x = x + _dx[0];
                dir = "S";
                ans++;
            } else if (dir.equals("W")) {
                y = y + _dy[2];
                x = x + _dx[2];
                dir = "N";
                ans++;
            } else if (dir.equals("N")) {
                y = y + _dy[3];
                x = x + _dx[3];
                dir = "W";
                ans++;
            }
        }

        if (!inRange(x, y)) {
            System.out.println(ans);
        } else {
            reflect(arr, x, y, dir);
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
