package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17143_낚시왕 {
    private static int R, C, M, r,c,s,d,z,nr,nc;
    private static int[] dr = {0, -1, 1, 0, 0}; // 상 하 우 좌
    private static int[] dc = {0, 0, 0, 1, -1};
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;
    public static final int LEFT = 4;
    private static PriorityQueue<Shark>[] sharks;
    private static Shark[][] temp;
    private static class Shark {
        private int row, col, speed, direction, size;

        private Shark(int r, int c, int s, int d, int z) {
            row = r;
            col = c;
            speed = s;
            direction = d;
            size = z;
        }
    }

    private static class Pair {
        int idx;
        Shark shark;

        private Pair(int idx, Shark shark) {
            this.idx = idx;
            this.shark = shark;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sharks = new PriorityQueue[C];

        for (int i = 0; i < C; i++) {
            sharks[i] = new PriorityQueue<>(Comparator.comparingInt(o -> o.row));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            sharks[c].add(new Shark(r, c, s, d, z));
        }
        int ans = 0;

        for (int fisherIdx = 0; fisherIdx < C; fisherIdx++) { // 낚시왕이 움직이는 횟수만큼
            // 상어 하나 낚기
            if (!sharks[fisherIdx].isEmpty()) {
//                System.out.println("sharks[fisherIdx].peek().size = " + sharks[fisherIdx].peek().size);
                ans += sharks[fisherIdx].poll().size;
            }

            // 상어 이동하기
            temp = new Shark[R][C];
            List<Pair> delList = new ArrayList<>();
            for (int i = 0; i < C; i++) {
                for (Shark shark : sharks[i]) {
                    r = shark.row;
                    c = shark.col;
                    s = shark.speed;
                    d = shark.direction;
                    z = shark.size;

                    nr = r + dr[d]*s;
                    nc = c + dc[d]*s;

                    if (d == DOWN) {
                        if (nr >= R) {
                            nr = (nr - R) % ((R - 1) * 2);
                            if (nr >= R - 1) {
                                nr = nr - (R - 1) + 1;
                            } else {
                                nr = (R - 1) - (nr + 1);
                                shark.direction = UP;
                            }
                        }
                    } else if (d == UP) {
                        if (nr < 0) {
                            nr = (Math.abs(nr) - 1) % ((R - 1) * 2);
                            if (nr >= R - 1) {
                                nr = (R - 1) - (nr - (R - 1)) - 1;
                            } else {
                                nr = nr + 1;
                                shark.direction = DOWN;
                            }
                        }
                    } else if (d == RIGHT) {
                        if (nc >= C) {
                            nc = (nc - C) % ((C - 1) * 2);
                            if (nc >= C - 1) {
                                nc = nc - (C - 1) + 1;
                            } else {
                                nc = (C - 1) - (nc + 1);
                                shark.direction = LEFT;
                            }
                        }
                    } else if (d == LEFT) {
                        if (nc < 0) {
                            nc = (Math.abs(nc) - 1) % ((C - 1) * 2);
                            if (nc >= C - 1) {
                                nc = (C - 1) - (nc - (C - 1)) - 1;
                            } else {
                                nc = nc + 1;
                                shark.direction = RIGHT;
                            }
                        }
                    }

                    // 위치가 구해졌으니 상어 잡아먹기 진행
                    if (temp[nr][nc] != null) {
                        if (temp[nr][nc].size > shark.size) {
                            continue;
                        }
                    }
                    temp[nr][nc] = shark;
                }
            }

            for (int i = 0; i < C; i++) {
                sharks[i].clear();
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
//                    System.out.print(temp[i][j] == null ? "0 " : temp[i][j].size + " ");
                    if (temp[i][j] != null) {
                        temp[i][j].row = i;
                        temp[i][j].col = j;
                        sharks[j].add(temp[i][j]);
                    }
                }
//                System.out.println();
            }
//            System.out.println("---------------");

        }
        System.out.println(ans);
    }
}
