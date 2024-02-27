package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Intuition 각 회의가 겹치지 않게 하면서 회의실을 사용하는 회의의 '최대' 개수 -> 회의가 짧은 것들을 greedy하게 고르면 됨
 *
 * @algorithm greedy
 * @time O(N * logN + N) ; 정렬 NlogN + 순회 N -> 516 ms
 * @memoty O(N) ; 배열 2N -> 43344 KB
 */
public class BOJ_1931_회의실배정 {
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 끝나는시간 오름차순(짧은거 먼저) + 끝나는시간 같으면 시작시간 오름차순
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int cnt = 0;
        int prevEnd = 0;
        for (int[] meeting : arr) {
            int start = meeting[0];
            int end = meeting[1];
            if (prevEnd <= start) {
                cnt++;
                prevEnd = end;
            }
        }
        System.out.println(cnt);
    }
}
