package 코드트리.시뮬레이션.dxdy테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방향회전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int x = 1, y = 5;
        int dir = 0;
        int[] dx = new int[]{1, 0, -1, 0}; // E S W N
        int[] dy = new int[]{0, -1, 0, 1};

        // clockwise rotation (90 degree)
        dir = (dir + 1) % 4;

        x = x + dx[dir];
        y = y + dy[dir];


        /*
        반시계 방향에 대한 회전은, 현재 dirNum에서 1을 빼주면 됩니다.
        다만 이 경우 dirNum이 0일때 다시 3이 되어야 하므로,
        그 다음 dirNum을 (dirNum + 3) % 4로 설정하는 것이 좋습니다.

        (dirNum - 1) % 4로 진행할 경우,
        dirNum이 0일 때 -1 % 4는 -1 값을 갖게 되므로 원하는 결과를 얻을 수 없습니다.
        **/

        // counter-clockwise rotation (90 degree)
        dir = (dir - 1 + 4) % 4; //
    }
}
