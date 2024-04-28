import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 현재 N개의 앱, A1, ..., AN이 활성화 되어 있다고 가정하자. 이들 앱 Ai는 각각 mi 바이트만큼의 메모리를 사용하고 있다.
 * 앱 Ai를 비활성화한 후에 다시 실행하고자 할 경우, 추가적으로 들어가는 비용(시간 등)을 수치화 한 것을 ci
 * 이러한 상황에서 사용자가 새로운 앱 B를 실행하고자 하여, 추가로 M 바이트의 메모리가 필요하다고 하자.
 * 즉, 현재 활성화 되어 있는 앱 A1, ..., AN 중에서 몇 개를 비활성화 하여 M 바이트 이상의 메모리를 추가로 확보해야 하는 것이다.
 * 여러분은 그 중에서 비활성화 했을 경우의 비용 ci의 합을 최소화하여 필요한 메모리 M 바이트를 확보하는 방법을 찾아야 한다.
 * 1 ≤ N ≤ 100, 1 ≤ M ≤ 10,000,000
 *
 * 단순 완탐 풀이
 * 1. 부분집합을 이용하여 선택 유무 전체 탐색으로 M 이상의 경우가 된 때의 비용 체크 ~ 반복하여 최소값 탐색
 *
 * knapsack 풀이
 * 1. 무게가 x일 때의 최소 비용 dp[x]
 */
public class Main {

    private static int N, M;
    private static int[] A, C;
    private static int[] dp;
    private static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken()); // 메모리 사용량
        }

        st = new StringTokenizer(br.readLine());
        C = new int[N+1];
        for (int i = 1; i <= N; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[10_000+1];

        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 10000; j >= C[i]; j--) {
                if (dp[j - C[i]] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - C[i]] + A[i]);
                }
            }
        }

        for (int i = 0; i <= 10000; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
        br.close();
    }

}