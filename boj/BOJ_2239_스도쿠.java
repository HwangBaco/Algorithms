package 알고리즘연습.boj;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @time
 */
public class BOJ_2239_스도쿠 {
    private static int[] rowFlag = new int[10]; // 1 ~ 9번째 row에 대하여 고른 숫자 선택
    private static int[] colFlag = new int[10]; // 1 ~ 9번째 col에 대하여 고른 숫자 선택
    private static int[][] secFlag = new int[4][4]; // 3 x 3 섹션에 대하여 고른 숫자 선택
    private static int[][] map = new int[10][10];
    private static List<int[]> zeros = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    private static boolean hasAnswer = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 9; i++) {
            String s = br.readLine();
            for (int j = 1; j <= 9; j++) {
                int num = Integer.parseInt(s.substring(j- 1, j));
                rowFlag[i] |= 1 << num;
                colFlag[j] |= 1 << num;
                secFlag[((i - 1) / 3) + 1][((j - 1) / 3) + 1] |= 1 << num;
                map[i][j] = num;
                if (num == 0) {
                    zeros.add(new int[]{i, j});
                }
            }
        }

        go(0);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void go(int depth) {
        if (hasAnswer) {
            return;
        }
        if (depth == (zeros.size())) {
            // 정답에 일치하는 경우
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            hasAnswer = true;
            return;
        }

        int[] z = zeros.get(depth);
        int y = z[0];
        int x = z[1];
        for (int j = 1; j <= 9; j++) {
            if (((rowFlag[y] & 1 << j) == 0) && ((colFlag[x] & 1 << j) == 0) && ((secFlag[((y - 1) / 3) + 1][((x - 1) / 3) + 1] & 1 << j) == 0)) {
                map[y][x] = j;
                rowFlag[y] |= 1 << j;
                colFlag[x] |= 1 << j;
                secFlag[((y - 1) / 3) + 1][((x - 1) / 3) + 1] |= 1 << j;
                go(depth + 1);
                map[y][x] = 0;
                rowFlag[y] &= ~(1 << j);
                colFlag[x] &= ~(1 << j);
                secFlag[((y - 1) / 3) + 1][((x - 1) / 3) + 1] &= ~(1 << j);
            }
        }
    }
}
