package 코드트리.시뮬레이션.dxdy테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상하좌우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // E S W N
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        int x = 0, y = 0;
        /*
        n : loop size
        방향 + 거리 주어짐
        **/
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());
            x = x + dx[move(dir)] * dist;
            y = y + dy[move(dir)] * dist;
        }
        System.out.println(x + " " + y);
    }
    public static int move(String dir) {
        if (dir.equals("N")) {
            return 3;
        } else if (dir.equals("E")) {
            return 0;
        } else if (dir.equals("S")) {
            return 1;
        } else if (dir.equals("W")) {
            return 2;
        }
        return -1;
    }
}
