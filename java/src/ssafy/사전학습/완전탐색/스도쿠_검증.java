package ssafy.사전학습.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 스도쿠_검증 {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static final int GRID_SIZE = 9;
    public static void main(String[] args) throws IOException {
        // 가로 검증
        // 세로 검증
        // 박스 검증
        // 전부 리니어하게 수행해도 결과를 얻을 수 있고, 연산 횟수가 총 81회 * 3이므로 완탐 가능

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= t; i++) {
            int[][] grid = initGrid();
            boolean isRightRows = isRightRows(grid);
            boolean isRightColumns = isRightColumns(grid);
            boolean isRightBoxes = isRightBoxes(grid);
            StringBuffer sb = new StringBuffer().append("#").append(i).append(" ");
            if (isRightBoxes && isRightColumns && isRightRows) {
                sb.append(1);
                System.out.println(sb);
                continue;
            }
            sb.append(0);
            System.out.println(sb);
        }

    }

    private static int[][] initGrid() throws IOException {
        int[][] grid = new int[GRID_SIZE][GRID_SIZE];
        StringTokenizer st;
        for (int j = 0; j < GRID_SIZE; j++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < GRID_SIZE; k++) {
                grid[j][k] = Integer.parseInt(st.nextToken());
            }
        }
        return grid;
    }

    private static boolean isRightRows(int[][] grid) {
        for (int i = 0; i < GRID_SIZE; i++) {
            HashMap<Integer, Boolean> m = new HashMap<>();
            for (int j = 0; j < GRID_SIZE; j++) {
                if (m.getOrDefault(grid[i][j], false)) {
                    return false;
                }
                m.put(grid[i][j], true);
            }
        }
        return true;
    }

    private static boolean isRightColumns(int[][] grid) {
        for (int i = 0; i < GRID_SIZE; i++) {
            Map<Integer, Boolean> m = new HashMap<>();
            for (int j = 0; j < GRID_SIZE; j++) {
                if (m.getOrDefault(grid[j][i], false)) {
                    return false;
                }
                m.put(grid[j][i], true);
            }
        }
        return true;
    }

    private static boolean isRightBoxes(int[][] grid) {
        for (int i = 0; i < GRID_SIZE; i = i + 3) {
            for (int j = 0; j < GRID_SIZE; j = j + 3) {
                Map<Integer, Boolean> m = new HashMap<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (m.getOrDefault(grid[i + k][j + l], false)) {
                            return false;
                        }
                        m.put(grid[i + k][j + l], true);
                    }
                }
            }
        }
        return true;
    }
}
