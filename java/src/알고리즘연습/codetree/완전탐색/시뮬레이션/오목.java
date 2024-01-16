package 코드트리.완전탐색.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목 {
    private static final int MAX = 19;
    private static int ans = 0, x = 0, y = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[MAX][MAX];
        for (int i = 0; i < MAX; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAX; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                boolean check = false;
                if (arr[i][j] == 1) {
                    check = check(arr, i, j, 1);
                } else if (arr[i][j] == 2) {
                    check = check(arr, i, j, 2);
                }
                if (check) break;
            }
        }
        System.out.println(ans);
        if (ans != 0) {
            System.out.print(y + " " + x);
        }

    }

    private static boolean check(int[][] arr, int i, int j, int num) {
        boolean isGaro = true;
        boolean isSero = true;
        boolean isDaegakR = true;
        boolean isDaegakL = true;
        for (int k = 0; k < 5; k++) {
            if (j+k >= MAX || arr[i][j + k] != num) {
                isGaro = false;
            }
            if (i+k >= MAX || j+k >= MAX || arr[i + k][j + k] != num) {
                isDaegakR = false;
            }
            if (i+k >= MAX || arr[i + k][j] != num) {
                isSero = false;
            }
            if (i + k >= MAX || j - k < 0 || arr[i + k][j - k] != num) {
                isDaegakL = false;
            }
        }
        if (isGaro) {
            ans = num;
            x = j + 3;
            y = i + 1;
            return true;
        } else if (isSero) {
            ans = num;
            x = j + 1;
            y = i + 3;
            return true;
        } else if (isDaegakR) {
            ans = num;
            x = j + 3;
            y = i + 3;
            return true;
        } else if (isDaegakL) {
            ans = num;
            x = j - 1;
            y = i + 3;
        }
        return false;
    }
}
