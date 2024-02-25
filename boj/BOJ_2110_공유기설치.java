package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author HwangBaco
 * @algorithm parametric search
 * @time O(log N)
 *
 * N : 집 개수
 * C : 공유기 개수
 *
 * 집 좌표를 입력받아 정렬
 *
 * 거리 -> N으로 초기 설정하고 거리를 이진탐색
 * 집 좌표를 순회하면서 기준 거리가 넘어갈 때 routerCnt++, 기준 좌표 재설정
 * 다 돌고 나서 routerCnt가 C와 일치하면 dist = Math.max(dist, i) 갱신
 */
public class BOJ_2110_공유기설치 {
    private static int N, C;
    private static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new long[N+1];
        arr[0] = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        // 거리 이진탐색
        long ans = binarySearch();
        System.out.println(ans);
    }

    private static long binarySearch() {
        long left = 0;
        long right = arr[N];
        long targetDist = 0; // "가장 인접한" 두 라우터 간 거리
        long ansDist = 0;
        while (left <= right) {
            targetDist = (left + right) / 2;
//            System.out.println("targetDist = " + targetDist);
            long curDist = 0;
            int routerCnt = 1; // 첫 번째 집에 설치하고 시작.
            for (int i = 2; i <= N; i++) {
                curDist += arr[i] - arr[i-1];
                if (curDist >= targetDist) {
//                    System.out.println("arr[i] = " + arr[i]);
                    curDist = 0;
                    routerCnt++;
                }
            }

            // 가능한 경우에는 더 늘려서 -> 최대가 되게
            if (routerCnt >= C) {
                left = targetDist + 1;
                ansDist = Math.max(ansDist, targetDist); // 수정 부분
            } else {
                right = targetDist - 1;
            }
        }
        return ansDist;
    }

}
