package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * k : 20 이하
 * 자석 : 4개
 * 날 : 8개
 * N극 : 0 , S극 : 1
 * 시계방향 : 1 , 반시계 -1
 *
 * 조건1. 하나의 자석이 1 칸 회전될 때, 붙어 있는 자석은 서로 붙어 있는 날의 자성과 "다를 경우에만" 인력에 의해 반대 방향으로 1 칸 회전된다. (자성이 일치 여부 판단)
 * 조건2. 회전이 끝난 후 점수 계산 방법은 아래와 같다.
 * - 1 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 1 점을 획득한다.
 * - 2 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 2 점을 획득한다.
 * - 3 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 4 점을 획득한다.
 * - 4 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 8 점을 획득한다.
 *
 * @return 모든 자석의 회전이 끝난 후 획득한 점수의 총 합이다.
 */
public class SWEA_특이한자석 {

    // 0번 인덱스에 방향키가 있다고 가정
    // 2번, 6번 인덱스가 맞닿는 포인트
    public static final int R = 2;
    public static final int L = 6;
    public static List<int[]> turnList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) { // 50개 TC에 5초
            int K = Integer.parseInt(br.readLine()); // K <= 20 자연수
            int[][] wheels = new int[5][8];
            for (int i = 1; i <= 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    wheels[i][j] = Integer.parseInt(st.nextToken()); // 자성정보 (0 : N극, 1 : S극)
                }
            }
            for (int i = 0; i < K; i++) {
                turnList.clear();

                st = new StringTokenizer(br.readLine());
                int w = Integer.parseInt(st.nextToken()); // 회전시키려는 자석 번호
                int d = Integer.parseInt(st.nextToken()); // 회전 방향 (1 : 오른쪽, -1 : 왼쪽)
                turnList.add(new int[]{w, d});

                // TODO : 회전 시작 전에 회전할 톱니 체크 -> turnList {자석 번호, 회전 방향} 담아둠
                findChainTurnList(w, d, wheels);

                // TODO : turnList 순회하면서 자석 회전 - turn()
                executeChainTurn(wheels);
            }

            int ans = 0;
            for (int i = 1; i <= 4; i++) {
                ans += (wheels[i][0] << (i - 1));
            }
            sb.append(String.format("#%d %d\n", tc, ans));
        }
        br.close();
        System.out.println(sb.toString());
    }

    private static void executeChainTurn(int[][] wheels) {
        for (int[] turnInfo : turnList) {
            int wheel = turnInfo[0];
            int dir = turnInfo[1];
            turn(wheels, wheel, dir);
        }
    }

    private static void findChainTurnList(int w, int d, int[][] wheels) {
        int ww = w;
        int prevD = d;
        while (--ww >= 1) { // 왼쪽 바퀴 회전가능여부 검사
            if (wheels[ww][R] == wheels[ww + 1][L]) {
                break;
            }
            turnList.add(new int[]{ww, prevD = (prevD == 1 ? -1 : 1)});
        }
        ww = w;
        prevD = d;
        while (++ww <= 4) {
            if (wheels[ww][L] == wheels[ww - 1][R]) {
                break;
            }
            turnList.add(new int[]{ww, prevD = (prevD == 1 ? -1 : 1)});
        }
    }
    private static void turn(int[][] wheels, int wheel, int dir) {
        int[] temp = new int[8];
        int tdx = dir == 1 ? 1 : 7;

        // 오른쪽으로 돌리는 건 0이 1이 되어야 함, 1 -> 2 , ...
        // 왼쪽으로 돌리는 건 0이 7이 되어야 함, 1 -> 0 , 2 -> 1 , ...
        for (int i = 0; i < 8; i++) {
            temp[tdx] = wheels[wheel][i];
            tdx = (tdx + 1) % 8;
        }
        wheels[wheel] = temp.clone();
    }
}
