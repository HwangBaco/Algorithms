package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_프로세서연결하기 {
    /*
    * 시간 : 211 ms
    * */
    private static List<int[]> indexes;
    private static int coreCnt, ans, N;
    private static int maxCount;
    private static int[][] map;
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            indexes = new ArrayList<>();
            ans = 12 * 12;
            maxCount = 0;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            coreCnt = 0;


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        if ((i != 0 && i != N - 1) && (j != 0 && j != N - 1)) {
                            indexes.add(new int[]{i, j});
                            coreCnt++;
                        }
                    }
                }
            }
            // core들의 연결 길이를 백트래킹으로 최소값 갱신하면서 연결해야함
            // core 순회하면서
            // 방향으로 연결 가능하면 연결하고, go, 연결 해제하고
            // 최종 depth에서 result 값 갱신
            go( 0, 0, 0);

            sb.append(String.format("#%d %d\n", tc, ans));
        }
        System.out.println(sb.toString());
    }

    private static void go(int depth, int res, int workCnt) {
        if (depth == coreCnt) {
            if (maxCount == workCnt) {
                ans = Math.min(res, ans);
            } else if (maxCount < workCnt) {
                maxCount = workCnt;
                ans = res;
            }
            return;
        }

        int[] core = indexes.get(depth);
        int y = core[0];
        int x = core[1];
        for (int dir = 0; dir < 4; dir++) {
            if (canConnect(y, x, dir)) {
                int temp = connect(y, x, dir);
                go(depth + 1, res + temp, workCnt + 1);
                unConnect(y, x, dir);
            }
        }
        go(depth + 1, res, workCnt);
    }

    private static int connect(int y, int x, int dir) {
        int res = 0;
        int ny = dy[dir];
        int nx = dx[dir];
        while (y > 0 && y < N - 1 && x > 0 && x < N - 1) {
            y += ny;
            x += nx;
            map[y][x] = 1;
            res++;
        }
        return res;
    }

    private static void unConnect(int y, int x, int dir) {
        int ny = dy[dir];
        int nx = dx[dir];
        while (y > 0 && y < N - 1 && x > 0 && x < N - 1) {
            y += ny;
            x += nx;
            map[y][x] = 0;
        }
    }

    private static boolean canConnect(int y, int x, int dir) {
        int ny = dy[dir];
        int nx = dx[dir];
        while (y > 0 && y < N - 1 && x > 0 && x < N - 1) {
            y += ny;
            x += nx;
            if (map[y][x] == 1) {
                return false;
            }
        }

        return true;
    }
}
