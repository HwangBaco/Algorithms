package 코드트리.완전탐색.forLoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양수_직사각형의_최대_크기 {
    private static int n, m;
    private static int[][] arr;
    private static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 높이가 n'인 직사각형
        for (int i = 1; i <= n; i++) {
            // 길이가 m'인 직사각형
            for (int j = 1; j <= m; j++) {
                // 기준 y좌표
                for (int y = 0; y < n; y++) {
                    // 기준 x좌표
                    for (int x = 0; x < m; x++) {
                        boolean isRectangle = true;
                        for (int k = y; k < y + i; k++) {
                            for (int l = x; l < x + j; l++) {
                                if (!inRange(k, l)) {
                                    isRectangle = false;
                                } else if (arr[k][l] < 0) {
                                    isRectangle = false;
                                }
                            }
                        }
                        // if (isRectangle):
                        // 우선순위 큐에 넓이 입력
                        if (isRectangle) {
                            pq.add(-(i * j));
                        }
                    }
                }
            }
        }
        if (pq.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(-pq.poll());
        }

    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
