package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {
    // 572 ms
    private static int N, D, K, C;
    private static int[] sushis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        sushis = new int[N];
        int[] cnt = new int[D+1];
        for (int i = 0; i < N; i++) {
            int sushiType = Integer.parseInt(br.readLine());
            sushis[i] = sushiType;
        }
        int left = 0;
        int right = K;
        int size = 0;
        int ans = 0;
        for (int i = left; i < right; i++) {
            if (sushis[i] != C && cnt[sushis[i]] == 0) {
                // C인 초밥은 어차피 반드시 공짜로 받으므로 먹는 종류의 개수에 영향을 줄 수 없음
                // -> 따라서 제외하고 count 진행
                size++;
            }
            cnt[sushis[i]]++;
        }
        ans = size; // 초반 사이즈 answer에 대입

        // 윈도우 이동
        while (left < N) {
            // 만약 왼쪽 끝 접시에 C가 담긴 것만 아니라면
            if (sushis[left] != C) {
                // 그걸 치우면 이제 하나가 줄어드는 거라면
                if (cnt[sushis[left]] == 1) {
                    size--;
                }
                cnt[sushis[left]]--;
            }

            if (sushis[(right) % N] != C) {
                if (cnt[sushis[(right) % N]] == 0) {
                    size++;
                    ans = Math.max(ans, size);
                }
                cnt[sushis[(right) % N]]++;
            }

            left++;
            right++;
        }
        System.out.println(ans + 1); // C를 제거하여 카운트하므로 C를 정답에서 추가하여 카운트

    }
}
