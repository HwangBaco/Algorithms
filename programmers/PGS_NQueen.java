package 알고리즘연습.programmers;

import java.util.*;

/**
 * @intuition 가로 세로의 길이가 n으로 동일 (n은 12 이하의 자연수)
 * <p>
 * n이 작다는 건 완탐 확률이 높다는 것
 * -> 백트래킹으로 접근하여 모든 경우를 훑으면 될 것이다.
 * @algorithm bruteforce(backtracking)
 * @time O(N ^ 2)
 * @memory O(N)
 */
public class PGS_NQueen {
    static int ans;
    static int[] row;

    public int solution(int n) {
        row = new int[n];
        go(0, n);

        return ans;
    }

    private void go(int y, int n) {
        if (y == n) {
            ans++;
            return;
        }
        for (int x = 0; x < n; x++) {
            if (isPromising(y, x, n)) {
                row[y] = x;
                go(y + 1, n);
                row[y] = 0;
            }
        }

    }

    private boolean isPromising(int y, int x, int n) {
        for (int i = 0; i < y; i++) {
            if (x == row[i] || Math.abs(x - row[i]) == Math.abs(y - i)) {
                return false;
            }
        }
        return true;
    }
}
