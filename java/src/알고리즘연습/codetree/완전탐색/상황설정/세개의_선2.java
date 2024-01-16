package 코드트리.완전탐색.상황설정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 세개의_선2 {
    private static int[][] arr;
    private static final int SIZE = 11;
    private static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x, y;
        arr = new int[SIZE][SIZE];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr[y][x] = 1;
        }
        // iteration
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                // 좌표 하나 정하기
                if (arr[i][j] == 1) {
                    // 가로세로 둘다 봐서 더 많이 겹치는 쪽으로 선긋기
                    int xCnt = 0, yCnt = 0;
                    for (int _x = 0; _x <= 10; _x++) {
                        xCnt = countXLinearPoints(i, xCnt, _x);
                    }
                    for (int _y = 0; _y <= 10; _y++) {
                        yCnt = countYLinearPoints(j, yCnt, _y);
                    }
                    drawLineHasMorePoints(i, j, xCnt, yCnt);
                    ans++;
                }
            }
        }
        System.out.println(ans <= 3 ? 1 : 0);

    }

    private static void drawLineHasMorePoints(int i, int j, int xCnt, int yCnt) {
        if (xCnt > yCnt) {
            drawXLine(i);
        } else {
            drawYLine(j);
        }
    }

    private static int countXLinearPoints(int i, int xCnt, int _x) {
        if (arr[i][_x] == 1) {
            xCnt++;
        }
        return xCnt;
    }

    private static int countYLinearPoints(int j, int yCnt, int _y) {
        if (arr[_y][j] == 1) {
            yCnt++;
        }
        return yCnt;
    }

    private static void drawYLine(int j) {
        for (int _y = 0; _y <= 10; _y++) {
            arr[_y][j] = 0;
        }
    }

    private static void drawXLine(int i) {
        for (int _x = 0; _x <= 10; _x++) {
            arr[i][_x] = 0;
        }
    }
}
