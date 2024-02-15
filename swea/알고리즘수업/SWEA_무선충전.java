package 알고리즘연습.swea.알고리즘수업;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_무선충전 {
    /*
    * 실행시간 : 216 ms
    *
    * 메모리 : 29,864 kb
    *
    * 시간복잡도 : O(N * log N)
    * */
    static final int Y = 0;
    static final int X = 1;
    private static class Battery {
        int y, x, range, power;

        private Battery(int y, int x, int range, int power) {
            this.y = y;
            this.x = x;
            this.range = range;
            this.power = power;
        }
    }

    private static class PowerCombo {
        int power, idx;

        private PowerCombo(int power, int idx) {
            this.power = power;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // moving length
            int bc = Integer.parseInt(st.nextToken()); // battery count

            int[] amoves = new int[m];
            int[] bmoves = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                amoves[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                bmoves[i] = Integer.parseInt(st.nextToken());
            }

            List<Battery> batteries = new ArrayList<>();
            for (int i = 0; i < bc; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int range = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());
                batteries.add(new Battery(y, x, range, power));
            }
            int ans = solution(m, amoves, bmoves, batteries);
            bw.write(String.format("#%d %d\n", tc, ans));

        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static int solution(int m ,int[] amoves, int[] bmoves, List<Battery> batteries) {
        PriorityQueue<PowerCombo>[][] pm = new PriorityQueue[11][11];

        /* power map init */
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                pm[i][j] = new PriorityQueue<>((o1, o2) -> o2.power - o1.power);
                pm[i][j].add(new PowerCombo(0, -1));
                pm[i][j].add(new PowerCombo(0, -1));
                pm[i][j].add(new PowerCombo(0, -1));
                pm[i][j].add(new PowerCombo(0, -1)); // 겹쳤을 때 문제되는 상황 방지
            }
        }
        /* power map 배터리 입력 */
        int idx = 0;
        for (Battery b : batteries) {
            int y = b.y;
            int x = b.x;
            int r = b.range;
            int p = b.power;

            for (int i = y - r; i <= y + r; i++) {
                for (int j = x - r; j <= x + r; j++) {
                    if (inRange(i, j)) {
                        if (Math.abs(i - y) + Math.abs(j - x) <= r) {
                            pm[i][j].offer(new PowerCombo(p, idx)); // 최대값으로 넣기
                        }
                    }
                }
            }
            idx++;
        }

        /* 인간들 이동 */
        int ay = 1;
        int ax = 1;
        int by = 10;
        int bx = 10;
        int ans = pm[1][1].peek().power + pm[10][10].peek().power;

        int[] dy = {0, -1, 0, 1, 0}; // 움직X 상 우 하 좌
        int[] dx = {0, 0, 1, 0, -1};
        for (int i = 0; i < m; i++) {
            ay = ay + dy[amoves[i]];
            ax = ax + dx[amoves[i]];
            by = by + dy[bmoves[i]];
            bx = bx + dx[bmoves[i]];


            int apower = pm[ay][ax].peek().power;
            int aIdx = pm[ay][ax].peek().idx;
            int bpower = pm[by][bx].peek().power;
            int bIdx = pm[by][bx].peek().idx;
            /*
            * 위치 겹치는게 문제가 아니라, power가 동일하면 문제가 되는거임
            *
            * +++ 파워가 동일하면서 battery가 다를 수 있음. 그걸 인지해야 함. 그러니까 객체를 넣자.
            *
            * power가 겹칠 때 small power를 넣어주면 됨.
            * */

            if (aIdx == bIdx && aIdx != -1) { // 배터리가 겹치면
                if (samePos(ay, ax, by, bx)) {
                    // 아예 위치가 겹치는 놈은 간단히 처리하고 넘어감
                    PowerCombo a1 = pm[ay][ax].poll();
                    PowerCombo a2 = pm[ay][ax].peek();
                    ans += a1.power + a2.power;
                    pm[ay][ax].add(a1);
                    continue;
                }

                PowerCombo a1 = pm[ay][ax].poll();
                PowerCombo a2 = pm[ay][ax].peek();

                PowerCombo b1 = pm[by][bx].poll();
                PowerCombo b2 = pm[by][bx].peek();

                if (a2.power > b2.power) {
                    int res = a2.power + b1.power;
                    ans += res;
                } else {
                    int res = a1.power + b2.power;
                    ans += res;
                }
                pm[ay][ax].add(a1);
                pm[by][bx].add(b1);

            } else { // 파워 안겹치면
                ans += apower;
                ans += bpower;
            }
        }

        return ans;
    }

    private static boolean inRange(int y, int x) {
        return y >= 1 && y <= 10 && x >= 1 && x <= 10;
    }

    private static boolean samePos(int ay, int ax, int by, int bx) {
        return ay == by && ax == bx;
    }
}
