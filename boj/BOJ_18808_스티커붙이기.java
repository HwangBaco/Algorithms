package 알고리즘연습.boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_18808_스티커붙이기 {
    private static int ans;
    private static int N, M, K, R, C;
    private static int[][] map; // 노트북
    private static int[][] sticker; // 기본 스티커
    private static int turnCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            sticker = new int[R][C];

            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < C; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            turnCnt = 0;
            int y;
            int x;
            do {
                y = turnCnt % 2 == 0 ? R : C;
                x = turnCnt % 2 == 0 ? C : R;
                stick(y, x);
            } while (turn(y, x));
        }


        br.close();
        bw.write(sb.append(ans).toString());
        bw.flush();
        bw.close();
    }

    private static void stick(int y, int x) {
        for (int i = 0; i < N - y + 1; i++) {
            top:
            for (int j = 0; j < M - x + 1; j++) {
                // 기준 좌표 설정

                for (int k = 0; k < y; k++) {
                    for (int l = 0; l < x; l++) {
                        if (sticker[k][l] == 1 && map[i + k][j + l] == 1) {
                            continue top; // 다음 좌표 탐색
                        }
                    }
                }

                for (int k = 0; k < y; k++) {
                    for (int l = 0; l < x; l++) {
                        if (sticker[k][l] == 1) {
                            map[i + k][j + l] = sticker[k][l];
                            ans++;
                        }
                    }
                }
                turnCnt = 3; // 끝내기
                return;
            }
        }
    }
    private static boolean turn(int y, int x) {
        if (turnCnt == 3) {
            return false;
        }
        turnCnt++;


        // 배열 돌리기
        int[][] temp = new int[x][y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                temp[j][y - i - 1] = sticker[i][j];
            }
        }

        sticker = new int[x][y];
        for (int i = 0; i < x; i++) {
            sticker[i] = temp[i].clone();
        }



        return true;
    }

}
