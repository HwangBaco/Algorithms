package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_상호의배틀필드 {
    /*
    * 실행 시간 : 210 ms
    *
    * 메모리 : 33,872 KB
    * */
    private static final String LAND = ".";
    private static final String BRICK_WALL = "*";
    private static final String IRON_WALL = "#";
    private static final String WATER = "-";
    private static final String UP_TANK = "^";
    private static final String DOWN_TANK = "v";
    private static final String LEFT_TANK = "<";
    private static final String RIGHT_TANK = ">";
    private static int[] tankPos;
    private static int tankHeading;
    private static final int UP = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int RIGHT = 4;
    private static String[][] map;
    private static int H, W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            /* 지도 초기화 */
            map = new String[H][W];
            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    String mapObj = s.substring(j, j + 1);
                    map[i][j] = mapObj;
                    if (isTank(mapObj)) {
                        tankPos = new int[]{i, j};
                        tankHeading = setHeading(mapObj);
                    }
                }
            }

            /* 명령어 저장 */
            int cmdLength = Integer.parseInt(br.readLine());
            String cmds = br.readLine();

            for (int i = 0; i < cmdLength; i++) {
                String cmd = cmds.substring(i, i + 1);
                process(cmd);
            }

            System.out.printf("#%d ", tc);
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static void process(String cmd) {
        int[] dy = {0, -1, 1, 0, 0};
        int[] dx = {0, 0, 0, -1, 1};
        if (cmd.equals("S")) {
            // tankPos에서 tankHeading으로 움직이면서 벽이 있는지 체크
            // 범위 나가면 break;
            // 강철벽이면 break
            // 나무벽이면 map 수정하고 종료
            int y = tankPos[0];
            int x = tankPos[1];
            while (true) {
                y += dy[tankHeading];
                x += dx[tankHeading];
                if (!inRange(y, x)) {
                    return;
                }
                if (map[y][x].equals(IRON_WALL)) {
                    return;
                } else if (map[y][x].equals(BRICK_WALL)) {
                    map[y][x] = LAND; // 포탄을 맞은 벽돌벽은 평지가 된다.
                    return;
                }
            }
        } else if (cmd.equals("U")) {
            // 탱크 위치 조회
            int y = tankPos[0];
            int x = tankPos[1];

            // 탱크 방향 바꾸고
            tankHeading = UP;
            map[y][x] = UP_TANK;

            // 탱크 전진
            int ny = y + dy[tankHeading];
            int nx = x + dx[tankHeading];

            if (inRange(ny,nx) && map[ny][nx].equals(LAND)) {
                map[ny][nx] = UP_TANK;
                map[y][x] = LAND;
                tankPos = new int[]{ny, nx};
            }
        } else if (cmd.equals("D")) {
            // 탱크 위치 조회
            int y = tankPos[0];
            int x = tankPos[1];

            // 탱크 방향 바꾸고
            tankHeading = DOWN;
            map[y][x] = DOWN_TANK;

            // 탱크 전진
            int ny = y + dy[tankHeading];
            int nx = x + dx[tankHeading];

            if (inRange(ny,nx) && map[ny][nx].equals(LAND)) {
                map[ny][nx] = DOWN_TANK;
                map[y][x] = LAND;
                tankPos = new int[]{ny, nx};

            }

        } else if (cmd.equals("L")) {
            // 탱크 위치 조회
            int y = tankPos[0];
            int x = tankPos[1];

            // 탱크 방향 바꾸고
            tankHeading = LEFT;
            map[y][x] = LEFT_TANK;

            // 탱크 전진
            int ny = y + dy[tankHeading];
            int nx = x + dx[tankHeading];

            if (inRange(ny,nx) && map[ny][nx].equals(LAND)) {
                map[ny][nx] = LEFT_TANK;
                map[y][x] = LAND;
                tankPos = new int[]{ny, nx};

            }
        } else if (cmd.equals("R")) {
            // 탱크 위치 조회
            int y = tankPos[0];
            int x = tankPos[1];

            // 탱크 방향 바꾸고
            tankHeading = RIGHT;
            map[y][x] = RIGHT_TANK;

            // 탱크 전진
            int ny = y + dy[tankHeading];
            int nx = x + dx[tankHeading];

            if (inRange(ny,nx) && map[ny][nx].equals(LAND)) {
                map[ny][nx] = RIGHT_TANK;
                map[y][x] = LAND;
                tankPos = new int[]{ny, nx};

            }
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }
    private static boolean isTank(String mapObj) {
        return mapObj.equals(UP_TANK) || mapObj.equals(DOWN_TANK) || mapObj.equals(LEFT_TANK) || mapObj.equals(RIGHT_TANK);
    }

    private static int setHeading(String mapObj) {
        if (mapObj.equals(UP_TANK)) {
            return UP;
        } else if (mapObj.equals(DOWN_TANK)) {
            return DOWN;
        } else if (mapObj.equals(LEFT_TANK)) {
            return LEFT;
        } else if (mapObj.equals(RIGHT_TANK)) {
            return RIGHT;
        }
        return 0;
    }
}
