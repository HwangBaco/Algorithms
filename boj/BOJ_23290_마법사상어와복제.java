package 알고리즘연습.boj;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23290_마법사상어와복제 {
    private static int[][] track = new int[5][5]; // (1,1) ~ (4,4)
    private static Queue<int[]> fishes = new ArrayDeque<>();
    private static Queue<int[]> copy = new ArrayDeque<>();
    private static Queue<int[]> move = new ArrayDeque<>();
    private static Queue<int[]> delete = new ArrayDeque<>();
    private static int[][] fishMap = new int[5][5];
    private static int[][] fishMove = {{999, 999}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    private static int[][] sharkMove = {{999,999}, {-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // 상 좌 하 우
    private static int M, S, sharkY, sharkX;
    private static int[] maxScenario = new int[3]; // 이동 시나리오 저장 (방향 벡터만 저장)
    private static int swallowMax = -1; // 물고기 잡아먹는 최대 수 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 물고기의 수
        S = Integer.parseInt(st.nextToken()); // 시뮬레이션 수

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fishes.add(new int[]{y, x, d});
        }
        st = new StringTokenizer(br.readLine());
        sharkY = Integer.parseInt(st.nextToken());
        sharkX = Integer.parseInt(st.nextToken());

        simulation();

//        for (int[] fish : fishes) {
//            System.out.println("---fish---");
//            System.out.println("y = " + fish[0]);
//            System.out.println("x = " + fish[1]);
//            System.out.println("d = " + fish[2]);
//        }
//        System.out.println("-----track-----");
//        for (int i = 1; i <= 4; i++) {
//            for (int j = 1; j <= 4; j++) {
//                System.out.print(track[i][j] + " ");
//            }
//            System.out.println();
//        }

        br.close();
        bw.write(String.valueOf(fishes.size()));
        bw.flush();
        bw.close();
    }

    private static void simulation() {
        for (int tc = 0; tc < S; tc++) {

//            System.out.println("tc = " + tc);
//            System.out.println("냄새 현황");
            // 0. track 냄새빼기
            for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 4; j++) {
                    track[i][j] = track[i][j] > 0 ? track[i][j] - 1 : 0;
//                    System.out.print(track[i][j] + " ");
                }
//                System.out.println();
            }

            /* 1. 물고기 현위치 복제 */
            copy.addAll(fishes);

            /* 2. 모든 물고기 이동 */
            nextFish:
            for (int[] fish : fishes) {
                int y = fish[0];
                int x = fish[1];
                int d = fish[2];
                for (int j = 1; j <= 8; j++) {
                    if (j > 1) { // 처음을 제외하곤 방향 전환하고 진행방향 파악
                        d = d - 1 >= 1 ? d - 1 : 8;
                    }
                    int ny = y + fishMove[d][0];
                    int nx = x + fishMove[d][1];
                    if (canGo(ny, nx)) {
                        move.add(new int[]{ny, nx, d});
                        continue nextFish;
                    }
                }
                // 여기까지 왔다는건 물고기가 이동을 못했다는 것 -> 현 위치 그대로 입력
                move.add(fish);

            } // 모든 물고기 이동 종료.
            fishes.clear();
            fishes.addAll(move);
            move.clear();

            fishMap = new int[5][5];
            for (int[] fish : fishes) {
                fishMap[fish[0]][fish[1]]++;
            }

            // test
//            System.out.println("tc = " + tc);
//            System.out.println("-----fishmap------");
//            System.out.println("이동을 마친 상태");
//            for (int i = 1; i <= 4; i++) {
//                for (int j = 1; j <= 4; j++) {
//                    System.out.print(fishMap[i][j] + " ");
//                }
//                System.out.println();
//            }


            /* 3. 상어 연속 3칸 이동 */
            maxScenario = new int[3]; // 이동 시나리오 저장 (방향 벡터만 저장)
            swallowMax = -1; // 물고기 잡아먹는 최대 수 저장
//            System.out.println("tc = " + tc);
//            System.out.println("움직이기 전 상어 위치");
//            System.out.println("sharkY = " + sharkY);
//            System.out.println("sharkX = " + sharkX);
            go(sharkY, sharkX, 0, 0, new int[3], new boolean[5][5]);
            commit();
//            System.out.println("상어 움직임 시나리오");
//            for (int i : maxScenario) {
//                System.out.println("방향 = " + (i == 1 ? "UP " : (i == 2 ? "LEFT " : (i == 3 ? "DOWN " : "RIGHT "))));
//            }
//            System.out.println();

            /* 4. 복제했던 물고기들 반영 */
            fishes.addAll(copy);
//            System.out.println("tc = " + tc);
//            System.out.println("-----fishes------");
//            System.out.println("복제한 물고기들까지 반영된 상태");
//            for (int[] fish : fishes) {
//                System.out.println("y = " + fish[0]);
//                System.out.println("x = " + fish[1]);
//                System.out.println("d = " + fish[2]);
//            }
            copy.clear();

        }
    }

    private static void commit() {
        int y = sharkY;
        int x = sharkX;

        for (int d : maxScenario) {
            y = y + sharkMove[d][0];
            x = x + sharkMove[d][1];
            delete.add(new int[]{y, x});
        }
        // 최종 이동 위치로 상어 위치 변경
        sharkY = y;
        sharkX = x;

        ArrayList<Integer>[][] temp = new ArrayList[5][5];
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                temp[i][j] = new ArrayList<>();
            }
        }
        for (int[] fish : fishes) {
            temp[fish[0]][fish[1]].add(fish[2]);
        }
        for (int[] del : delete) {
            if (temp[del[0]][del[1]].size() > 0) {
                track[del[0]][del[1]] = 3;
                temp[del[0]][del[1]].clear();
            }
        }
        fishes.clear();
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (temp[i][j].size() > 0) {
                    for (Integer k : temp[i][j]) {
                        fishes.add(new int[]{i, j, k});
                    }
                }
            }
        }
        delete.clear();
    }

    private static void go(int y, int x, int swallowCnt, int depth, int[] move, boolean[][] visited) {
        if (depth == 3) {
            if (swallowCnt > swallowMax) {
                maxScenario = move.clone();
                swallowMax = swallowCnt;
            } else if (swallowCnt == swallowMax) {
                int now = 0;
                int op = 0;
                int idx = 0;
                for (int i = 100; i > 0; i = i / 10) {
                    now += move[idx] * i;
                    op += maxScenario[idx] * i;
                    idx++;
                }
                if (now < op) { // 사전순으로 이번 시나리오가 앞서는 경우
                    maxScenario = move.clone();
                }
            }
            return;
        }
        for (int i = 1; i <= 4; i++) {
            int ny = y + sharkMove[i][0];
            int nx = x + sharkMove[i][1];
            if (inRange(ny, nx)) {
                move[depth] = i;
                if (visited[ny][nx]) {
                    go(ny, nx, swallowCnt, depth + 1, move, visited);
                } else {
                    visited[ny][nx] = true;
                    go(ny, nx, swallowCnt + fishMap[ny][nx], depth + 1, move, visited);
                    visited[ny][nx] = false;
                }
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 1 && y <= 4 && x >= 1 && x <= 4;
    }

    private static boolean noShark(int y, int x) {
        return y != sharkY || x != sharkX;
    }

    private static boolean noSmell(int y, int x) {
        return track[y][x] == 0;
    }

    private static boolean canGo(int y, int x) {
        return inRange(y, x) && noShark(y, x) && noSmell(y, x);
    }
}
