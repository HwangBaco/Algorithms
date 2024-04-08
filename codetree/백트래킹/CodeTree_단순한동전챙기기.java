package 알고리즘연습.codetree.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CodeTree_단순한동전챙기기 {
    private static int[][] selected = new int[3][3];
    private static List<int[]> coins = new ArrayList<>();
    private static int N, L, ans = (int) 1e9;
    private static int[] start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                if (c == 'S') {
                    start = new int[]{i, j};
                } else if (c == 'E') {
                    end = new int[]{i, j};
                } else if (c != '.') {
                    coins.add(new int[]{(int) c, i, j});
                }
            }
        }

        L = coins.size();

        coins.sort(Comparator.comparingInt(i -> i[0]));

        go(0, 0);

        System.out.println(ans == (int) 1e9 ? -1 : ans);
    }

    private static void go(int depth, int cnt) {
        if (cnt == 3) {
            int res = getTotalDist();
            ans = Math.min(ans, res);
            return;
        }
        for (int i = depth; i < L; i++) {
            selected[cnt] = coins.get(i);
            go(i + 1, cnt + 1);
        }
    }

    private static int getTotalDist() {
        int totalDist = 0;
        int prevY = selected[0][1]; // y
        int prevX = selected[0][2]; // x
        totalDist += Math.abs(start[0] - prevY) + Math.abs(start[1] - prevX);

        for (int i = 1; i < 3; i++) {
            int nowY = selected[i][1];
            int nowX = selected[i][2];
            totalDist += Math.abs(nowY - prevY) + Math.abs(nowX - prevX);
            prevY = nowY;
            prevX = nowX;
        }
        totalDist += Math.abs(end[0] - prevY) + Math.abs(end[1] - prevX);
        return totalDist;
    }
}
