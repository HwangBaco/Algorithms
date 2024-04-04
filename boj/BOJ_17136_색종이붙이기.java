package 알고리즘연습.boj;

import java.io.*;
import java.util.*;

public class BOJ_17136_색종이붙이기 {
    private static int[][] grid = new int[10][10];
    private static List<int[]> li = new ArrayList<>();
    private static int ans = (int) 1e9;
    private static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 5; i++) {
            map.put(i, 5);
        }

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, 0, 0);

        System.out.println(ans == (int) 1e9 ? -1 : ans);
    }

    private static void go(int y, int x, int depth) {
        if (y == 10 && x == 0) {
            ans = Math.min(ans, depth); // 가능한 최소 개수 반환
            return;
        }

        if (x >= 10) {
            go(y + 1, 0, depth);
            return;
        }

        if (grid[y][x] == 0) {
            go(y, x + 1, depth);
            return;
        }

        for (int l = 5; l >= 1; l--) {
            if (inRange(y, x, l) && canCover(y, x, l) && map.get(l) > 0) {
                apply(y, x, l);
                map.put(l, map.get(l) - 1);

                go(y, x + l, depth + 1);

                remove(y, x, l);
                map.put(l, map.get(l) + 1);
            }
        }
    }

    private static void remove(int y, int x, int l) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                grid[y +i][x + j] = 1;
            }
        }
    }

    private static void apply(int y, int x, int l) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                grid[y +i][x +j] = 0;
            }
        }
    }

    private static boolean canCover(int y, int x, int l) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (grid[y + i][x + j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean inRange(int y, int x, int l) {
        return y + l  - 1 < 10 && x + l - 1 < 10;
    }

}
