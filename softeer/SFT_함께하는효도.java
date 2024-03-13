package 알고리즘연습.softeer;

import java.io.*;
import java.util.*;

/**
 * @intuition 완탐일 것이다. 동시탐색을 코드로 구현하는 것이 핵심
 * @algorithm brute-force (permutation + dfs)
 * @time O(M! * N^2) 순열 O(M!) * DFS O(N^2) -> 87 ms
 * @memory O(N^2) 3차원 배열을 사용했지만 상수값으로 설정하므로 O(N^2) -> 11.46 MB
 */
public class SFT_함께하는효도 {
    private static int N, M, ans;
    private static int[][][] map;
    private static int[] ansArr;
    private static List<int[]> history;
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dx = {0, 0, 1, -1};
    private static final int VAL = 0;
    private static final int SUM = 1;
    private static final int CNT = 2;
    private static int[][] mPosArr;
    private static int[] selected;
    private static int[][][] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N][3];
        mPosArr = new int[M][2];
        selected = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j][VAL] = Integer.parseInt(st.nextToken());
            }
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            mPosArr[m][0] = y;
            mPosArr[m][1] = x;
        }

        perm(0, 0);



        br.close();
        bw.write(sb.append(ans).toString());
        bw.flush();
        bw.close();
    }

    private static void perm(int cnt, int visited) {
        if (cnt == M) {
            ansArr = new int[M];
            temp = new int[N][N][3];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[j][k] = map[j][k].clone();
                }
            }
            for (int i : selected) {
                int y = mPosArr[i][0];
                int x = mPosArr[i][1];
                temp[y][x][SUM] = temp[y][x][VAL];
                temp[y][x][CNT] = i * 10 + 1; // 10의 자리수로 각 인원을 구별
                List<int[]> footPrint = new ArrayList<>();
                footPrint.add(new int[]{y, x});
                go(y, x, i, footPrint);
                for (int[] pos : history) {
                    temp[pos[0]][pos[1]][CNT] = i;
                }
            }
            int res = Arrays.stream(ansArr).sum();
            ans = Math.max(res, ans);

            return;
        }
        for (int i = 0; i < M; i++) {
            if ((visited & 1 << i) != 0) {
                continue;
            }
            selected[cnt] = i;
            perm(cnt+1,visited | 1 << i);
        }
    }

    private static void go(int y, int x, int m, List<int[]> footPrint) {
        if ((temp[y][x][CNT] % 10) == 4) { // 1부터 시작 -> 4가 되었을 때 종료
            int mdx = temp[y][x][CNT] / 10; // 각 친구별 인덱스 추출
            if (temp[y][x][SUM] > ansArr[mdx]) {
                ansArr[mdx] = temp[y][x][SUM];
                // 갱신되었을 때에는, 이 케이스의 발자취를 저장해서 다음에 영향을 줘야 함.
                // 근데 이렇게 영향을 줄 발자취는 전부 탐색한 뒤에 결정이 가능함
                // 따라서 재귀 안에서는 자취만 기록해두고, 나중에 나가서 입력해야 함.
                history = new ArrayList<>();
                for (int[] ints : footPrint) {
                    history.add(ints);
                }
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (inRange(ny, nx)) {
                if (temp[ny][nx][CNT] > 0) {
                    continue;
                }
                temp[ny][nx][SUM] = temp[ny][nx][VAL] + temp[y][x][SUM];
                temp[ny][nx][CNT] = temp[y][x][CNT] + 1;
                if ((temp[ny][nx][CNT] % 10) <= 4) { // 1부터 시작 -> 4가 되었을 때 종료
                    footPrint.add(new int[]{ny, nx});
                    go(ny, nx, m, footPrint);
                    footPrint.remove(footPrint.size() - 1);
                    temp[ny][nx][SUM] = 0;
                    temp[ny][nx][CNT] = 0;
                }
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}
