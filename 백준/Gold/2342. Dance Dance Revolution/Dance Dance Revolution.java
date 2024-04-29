import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[][][] dp;
    private static List<Integer> li;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int SCORE = 2;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        li = new ArrayList<>();
        while (st.hasMoreTokens()) {
            li.add(Integer.parseInt(st.nextToken()));
        }
        N = li.size() - 1;
        li.remove(N);
        dp = new int[N][5][5];
        int answer = go(0, 0, 0);
        System.out.println(answer);
    }

    private static int go(int depth, int left, int right) {
        if (depth == N) {
            return 0;
        }
        if (dp[depth][left][right] != 0) {
            return dp[depth][left][right];
        }
        int next = li.get(depth);
        return dp[depth][left][right] = Math.min(go(depth+1, next, right) + getScore(left, next), go(depth+1, left, next) + getScore(right, next));
    }

    private static int getScore(int current, int next) {
        if (current == 0) {
            return 2;
        }
        return Math.abs(current - next) == 2 ? 4 : Math.abs(current - next) == 0 ? 1 : 3;
    }

}