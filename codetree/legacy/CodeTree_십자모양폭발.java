package 알고리즘연습.codetree.legacy;

import java.io.*;
import java.util.StringTokenizer;

/**
 * n : 격자 크기 (정사각형; 1 <= n <= 200)
 *
 * r, c : 폭탄이 터질 격자 좌표
 *
 * 구현 계획:
 * 1. 격자를 입력받아, 폭발 크기 먼저 체크
 * 2. 크기만큼 격자 델타탐색으로 데이터 -1로 반영
 * 3. 격자 완탐해서 -1 빼고 temp에 row 별로 저장
 * 4. temp 이용해서 다시 초기화
 */
public class CodeTree_십자모양폭발 {
    static int[] dx = {0, 1, 0, -1}; // 상 우 하 좌
    static int[] dy = {-1, 0, 1, 0};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int[] temp = new int[N]; // 폭발 이후 renew에 사용될 임시 배열
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        int bombSize = arr[r][c];

        for (int i = 0; i < 4; i++) {
            bomb(arr, r, c, 0, bombSize, i);
        }
        StringBuffer sb = new StringBuffer();

        for (int x = 0; x < N; x++) {
            int endIdx = 0;
            // 멀쩡한 부분 temp에 입력
            for (int y = N - 1; y >= 0; y--) {
                if (arr[y][x] != -1) {
                    temp[endIdx++] = arr[y][x];
                }
            }
            int idx = 0;
            for (int y = N - 1; y >= 0; y--) {
                arr[y][x] = temp[idx];
                temp[idx] = 0;
                idx++;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void bomb(int[][] arr, int r, int c, int depth, int bombSize, int dir) {
        if (depth == bombSize) {
            return;
        }
        arr[r][c] = -1;
        int nr = r + dy[dir];
        int nc = c + dx[dir];
        if (inRange(nr, nc)) {
            bomb(arr, nr, nc, depth + 1, bombSize, dir);
        }
    }

    private static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
