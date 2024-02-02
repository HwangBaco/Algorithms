package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {
    private static int ans = (int) 1e9;
    private static List<int[]> tastes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        // 재료 N 개
        // 각 재료는 신맛 S, 쓴맛 B
        // 신맛은 각 재료의 신맛의 곱
        // 쓴맛은 합
        // 공집합 x
        // 신맛과 쓴맛의 차이가 가장 작은 경우를 찾기
        // n이 10개 이하니까 조합으로 하면 됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            tastes.add(new int[]{sour, bitter});
        }

        comb2(0, 0, 1, 0, n);
        System.out.println(ans);
    }

    private static void comb(int depth, int cnt, int totalSour, int totalBitter, int n) {
        if (cnt >= 1) {
            ans = Math.min(ans, Math.abs(totalSour - totalBitter));
        }
        for (int i = depth; i < n; i++) {
            comb(i + 1, cnt + 1, totalSour * tastes.get(i)[0], totalBitter + tastes.get(i)[1], n);
        }
    }

    private static void comb2(int depth, int cnt, int totalSour, int totalBitter, int n) {
        if (depth == n) {
            if (cnt != 0) {
                ans = Math.min(ans, Math.abs(totalSour - totalBitter));
            }
            return;
        }
        comb(depth + 1, cnt + 1, totalSour*tastes.get(depth)[0], totalBitter+tastes.get(depth)[1] ,n);
        comb(depth + 1, cnt, totalSour, totalBitter ,n);
    }
}
