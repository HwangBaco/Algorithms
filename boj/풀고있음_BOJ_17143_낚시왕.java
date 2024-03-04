package 알고리즘연습.boj;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 */
public class 풀고있음_BOJ_17143_낚시왕 {
    private static int ans;
    private static int R, C, M;
    private static int[][][] map;
    private static int[] dy = {0, -1, 1, 0, 0}; // 상 하 우 좌
    private static int[] dx = {0, 0, 0, 1, -1};
    private static final int SPEED = 0;
    private static final int DIR = 1;
    private static final int SIZE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if (M == 0) {
            System.out.println(0);
            return;
        }
        map = new int[R + 1][C + 1][3];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[r][c][SPEED] = s;
            map[r][c][DIR] = d;
            map[r][c][SIZE] = z;
        }
        System.out.println("====start=====");
        print();

        for (int i = 1; i <= C; i++) {
            fish(i);
            System.out.println("=====after fish=====");
            print();
            move();
            System.out.println("=====after move======");
            print();
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    private static void fish(int C) {
        for (int i = 1; i <= R; i++) {
            int size = map[i][C][SIZE];
            if (size != 0) {
                ans += size;
                map[i][C][SPEED] = 0;
                map[i][C][SIZE] = 0;
                map[i][C][DIR] = 0;
                System.out.println(ans);
                return;
            }
        }
    }

    private static void move() {
        int[][][] temp = new int[R + 1][C + 1][3];
        for (int y = 1; y <= R; y++) {
            for (int x = 1; x <= C; x++) {

                if (map[y][x][SIZE] != 0) {
                    int ny = y;
                    int nx = x;
                    int nd = map[y][x][DIR];
                    // 음수 방향인 경우
                    if (map[y][x][DIR] == 1) { // 상
                        ny = y + map[y][x][SPEED] * dy[1];
                        if (ny <= 0) {
                            if ((Math.abs(ny) / (R - 1)) % 2 == 0) {
                                nd = 2; // 방향 전환
                                ny = (Math.abs(ny) % (R - 1)) + 2;
                                if (ny > R) {
                                    nd = 1; // 방향 전환
                                    ny = R - ((ny - (R + 1)) % (R - 1) + 1);
                                }
                            } else if ((Math.abs(ny) / (R - 1)) % 2 == 1) {
                                ny = R - ((Math.abs(ny) % (R - 1)) + 1);
                            }
                        }
                    } else if (map[y][x][DIR] == 4) { // 좌
                        nx = x + map[y][x][SPEED] * dx[4];
                        if (nx <= 0) {
                            if ((Math.abs(nx) / (C - 1)) % 2 == 0) {
                                nd = 3; // 방향 전환
                                nx = (Math.abs(nx) % (C - 1)) + 2;
                                if (nx > C) {
                                    nd = 4; // 방향 전환
                                    nx = C - ((nx - (C + 1)) % (C - 1) + 1);
                                }
                            } else if ((Math.abs(nx) / (C - 1)) % 2 == 1) {
                                nx = C - ((Math.abs(nx) % (C - 1)) + 1);
                            }
                        }
                    // 양수 방향인 경우
                    } else if (map[y][x][DIR] == 2) { // 하
                        ny = y + map[y][x][SPEED] * dy[2];
                        if (ny > R) {
                            if (((ny - (R + 1)) / (R - 1)) % 2 == 0) {
                                nd = 1; // 방향 전환
                                ny = R - ((ny - (R + 1)) % (R - 1) + 1);
                            } else if (((ny - (R + 1)) / (R - 1)) % 2 == 1) {
                                ny = (ny - (R + 1)) % (R - 1) + 1;
                            }
                        }
                    } else { // 우
                        nx = x + map[y][x][SPEED] * dx[3];
                        if (nx > C) {
                            if (((nx - (C + 1)) / (C - 1)) % 2 == 0) {
                                nd = 4; // 방향 전환
                                nx = C - ((nx - (C + 1)) % (C - 1) + 1);
                        } else if (((nx - (C + 1)) / (C - 1)) % 2 == 1) {
                                nx = (nx - (C + 1)) % (C - 1) + 1;
                            }
                        }
                    }
                    if (temp[ny][nx][SIZE] != 0) { // 이미 상어가 그 자리에 있는 경우
                        if (temp[ny][nx][SIZE] > map[y][x][SIZE]) {
                            continue;
                        }
                    }
                    temp[ny][nx][SPEED] = map[y][x][SPEED];
                    temp[ny][nx][SIZE] = map[y][x][SIZE];
                    temp[ny][nx][DIR] = nd;
                }

            }
        }
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                map[i][j][SPEED] = temp[i][j][SPEED];
                map[i][j][DIR] = temp[i][j][DIR];
                map[i][j][SIZE] = temp[i][j][SIZE];
            }
        }
    }

    private static void print() {
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                System.out.print(map[i][j][SIZE] > 0 ? "("+map[i][j][SIZE] +"," + map[i][j][DIR] + ") " : "( , ) ");
            }
            System.out.println();
        }
    }
}
