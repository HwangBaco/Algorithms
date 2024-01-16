package 코드트리.완전탐색.물체탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 상해버린 치즈 */
public class 상해버린치즈_틀림틀림틀림틀림틀림 {
    private static int n; // 사람 수
    private static int m; // 치즈 수
    private static int d; // 치즈 먹은 기록 수 (loop size)
    private static int s; // 아픈 기록 수 (loop size)
    private static int[][] drr;
    private static int[][] srr;
    private static final int P_IDX = 0;
    private static int[] visited;
    private static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        inputData();
        /*
        2차원 loop로 srr과 drr을 같이 순회하면서
        srr의 사람과 drr의 사람이 일치하고, srr의 time보다 drr의 time이 작을 때 -> drr의 치즈 m을 저장
        drr과 cheeseArr을 순회하며 drr[i][1]의 치즈와 cheeseArr[i]가 맞으면 cnt++;
        **/
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < s; j++) {
                findBadCheese(i, j);
            }
        }
        System.out.println(ans);

    }

    private static void findBadCheese(int i, int j) {
        if (drr[i][P_IDX] == srr[j][P_IDX] && drr[i][2] < srr[j][1]) {
            int badCheese = drr[i][1];
            /* 아픈 사람들이 모두 이 치즈를 먹었었다면 */
            int cnt = 0;
            for (int k = 0; k < s; k++) {
                for (int l = 0; l < d; l++) {
                    if (drr[l][P_IDX] == srr[k][P_IDX] && drr[l][1] == badCheese && visited[drr[l][P_IDX]-1] == 0) {
                        cnt++;
                        visited[drr[l][P_IDX]-1] = 1;
                    }
                }
            }
            System.out.println(cnt);
            if (cnt == s) {
                countBadCheese(badCheese);
            }
        }
    }

    private static void countBadCheese(int badCheese) {
        int cnt = 0;
        visited = new int[n];
        for (int k = 0; k < d; k++) {
            if (drr[k][1] == badCheese && visited[drr[k][P_IDX]-1] == 0) {
                cnt++;
                visited[drr[k][P_IDX]-1] = 1;
            }
        }
        ans = Math.max(ans, cnt);
    }

    private static void inputData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 사람 수
        m = Integer.parseInt(st.nextToken());   // 치즈 수
        d = Integer.parseInt(st.nextToken());   // 치즈 먹은 기록 수
        s = Integer.parseInt(st.nextToken());   // 아픈 기록 수
        drr = new int[d][3];
        srr = new int[s][2];
        visited = new int[n];
        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            drr[i] = new int[]{
                    Integer.parseInt(st.nextToken()),   // p : 몇 번째 사람이
                    Integer.parseInt(st.nextToken()),   // m : 몇 번째 치즈를
                    Integer.parseInt(st.nextToken())};  // t : 언제 먹었는지
        }
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            srr[i] = new int[]{
                    Integer.parseInt(st.nextToken()),   // p : 몇 번째 사람이
                    Integer.parseInt(st.nextToken())    // t : 언제 아팠는지
            };
        }
        br.close();
    }
}
