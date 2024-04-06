package 알고리즘연습.codetree.legacy;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.*;

public class CodeTree_숫자가가장큰인접한곳으로동시에이동 {
    static int N; // 격자 크기 (정사각형 ; 2 <= n <= 20)
    static int M; // 구슬 개수 (1 <= m <= n * n)
    static int T; // 시간 (1 <= t <= 100)
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N+1][N+1]; // 좌표를 편하게 처리하기 위해 1칸씩 더 추가
        int[][] temp = new int[N+1][N+1]; // 움직임 표시 배열

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        Queue<int[]> goosles = new ArrayDeque<>();

        // 일단 구슬의 위치를 temp에 저장해둠.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            temp[r][c] = 1;
            goosles.add(new int[]{r, c});
            cnt++;
        }

        // TIME start;
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < cnt; j++) { // 구슬 개수만큼 queue 탐색
                int[] goosle = goosles.poll();
                int r = goosle[0];
                int c = goosle[1];
                int res = 0;
                int nr = 0;
                int nc = 0;
                // 델타 탐색하여 타켓 위치 선정
                for (int l = 0; l < 4; l++) {
                    int candidateR = r + dy[l];
                    int candidateC = c + dx[l];
                    // 그 위치가 inRange이면서 가장 큰 위치면 해당 위치로 저장
                    if (inRange(candidateR, candidateC) && res < grid[candidateR][candidateC]) {
                        res = grid[candidateR][candidateC];
                        nr = candidateR;
                        nc = candidateC;
                    }
                }
                // 확정된 타겟 위치로 구슬 이동
                temp[r][c]--;
                temp[nr][nc]++;
            }
            cnt = 0;
            // 이동을 전부 마치고 나서 temp가 겹치면 (2가 되면) 지우고 cnt 관리
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    // 중첩된 구슬은 제거
                    if (temp[j][k] > 1) {
                        temp[j][k] = 0;
                    }
                    // 제거되고 남은 구슬만 보고 q에 추가
                    if (temp[j][k] == 1) {
                        goosles.add(new int[]{j, k});
                        cnt++;
                    }
                }
            }
        }
        // cnt 출력
//        bw.write(cnt);

        System.out.println(cnt);

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean inRange(int y, int x) {
        return y >= 1 && y <= N && x >= 1 && x <= N;
    }

}
