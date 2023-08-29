package 코드트리.시뮬레이션.dxdy테크닉;

import java.io.IOException;

public class 반대로_방향전환 {
    public static int n = 5;
    public static int x = 1, y = 2;
    public static int dirNum = 2;
    /*
    격자 끝에 도착하면 방향을 반대로 뒤집어 줘야 하기 때문에,
    dx, dy 정의시 다음과 같이 방향을 놓는 것이 좋습니다.
    **/
    /*
    0번과 3번이 반대 방향이 되도록 하고,
    1번과 2번이 반대 방향이 되도록 dx, dy를 설정했기 때문에
    방향을 뒤집는 작업은 숫자 3에서 현재 방향 번호를 빼주면 됩니다
    **/
    public static int[] dx = new int[]{0, 1, -1,  0};
    public static int[] dy = new int[]{1, 0,  0, -1};
    public static void main(String[] args) throws IOException {
//        while(keepMoving()) {
        while (true) {
            int nx = x + dx[dirNum], ny = y + dy[dirNum];
            if(!inRange(nx, ny))       // check whether position is out of grid
                dirNum = 3 - dirNum;   // change direction
            // move
            x = x + dx[dirNum];
            y = y + dy[dirNum];
        }
    }

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
}
