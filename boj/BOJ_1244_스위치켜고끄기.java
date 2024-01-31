package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {
    /*
    * 메모리 : 14308 KB
    *
    * 시간 : 132 ms
    * 
    * 로직 : 단순 구현
    * */
    static int[] switches;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // init : n
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        switches = new int[n];

        // init : switches
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        // init : student count
        st = new StringTokenizer(br.readLine());
        int stdCnt = Integer.parseInt(st.nextToken());

        // init : pairs
        for (int i = 0; i < stdCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            command(gender, num, n);
        }

        int idx = 0;
        int jdx;
        for (int i = 1; i <= (n / 20) + 1; i++) {
            jdx = 0;
            while (idx < n && jdx < 20) {
                jdx++;
                System.out.print(switches[idx++] + " ");
            }
            if (idx != n) {
                System.out.println();
            }
        }
    }
    private static void toggle(int idx) {
        int toggled = switches[idx] == 1 ? 0 : 1;
        switches[idx] = toggled;
    }

    private static void command(int gender, int num, int n) {
        switch (gender) {
            case 1: // 남자
                int origin = num;
                while (num - 1 < n) {
                    toggle(num - 1);
                    num = num + origin;
                }
                break;
            case 2: // 여자
                num--;
                toggle(num);
                int mirrorIdx = 1;
                while (inRange(num, mirrorIdx, n) && switches[num - mirrorIdx] == switches[num + mirrorIdx]) {
                    toggle(num - mirrorIdx);
                    toggle(num + mirrorIdx);
                    mirrorIdx++;
                }
                break;
        }

    }

    private static boolean inRange(int x, int mirrorIdx, int n) {
        int nx = x + mirrorIdx;
        int ny = x - mirrorIdx;
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}
