package 백준.모의테스트4주차_KAUPC대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3019_테트리스 {
    public static int n, p, ans = 0;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 지면 길이 (1 이상 100 이하)
        p = Integer.parseInt(st.nextToken()); // 블록 모양 넘버
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (p == 1) { // 1번 블록
            for (int i = 0; i < n; i++) {
                // 길이 4의 연속한 땅
                if (inRange(i + 3)
                        && arr[i] == arr[i + 1]
                        && arr[i + 1] == arr[i + 2]
                        && arr[i + 2] == arr[i + 3]) {
                    ans++;
                }
                // 길이 1의 연속한 땅
                ans++;
            }
        } else if (p == 2) { // 2번 블록
            for (int i = 0; i < n; i++) {
                // 길이 2의 연속한 땅
                if (inRange(i + 1)
                        && arr[i] == arr[i + 1]) {
                    ans++;
                }
            }
        } else if (p == 3) { // 3번 블록
            for (int i = 0; i < n; i++) {
                // 높차 1인 길이 2의 땅
                if (inRange(i + 1) && arr[i] - arr[i + 1] == 1) {
                    ans++;
                }
                // 높차 1인 길이 3의 땅
                if (inRange(i + 2) && arr[i] == arr[i + 1]
                        && arr[i + 2] - arr[i + 1] == 1) {
                    ans++;
                }
            }
        } else if (p == 4) { // 4번 블록
            for (int i = 0; i < n; i++) {
                // 높차 1인 길이 2의 땅
                if (inRange(i + 1) && arr[i + 1] - arr[i] == 1) {
                    ans++;
                }
                // 높차 1인 길이 3의 땅
                if (inRange(i + 2) && arr[i] - arr[i + 1] == 1
                        && arr[i + 1] == arr[i + 2]) {
                    ans++;
                }
            }
        } else if (p == 5) { // 5번 블록
            for (int i = 0; i < n; i++) {
                // 높이 101인 길이 3의 땅
                if (inRange(i + 2) && arr[i] - arr[i + 1] == 1
                        && arr[i + 2] - arr[i + 1] == 1) {
                    ans++;
                }
                // 높이 10
                if (inRange(i + 1) && arr[i] - arr[i + 1] == 1) {
                    ans++;
                }
                // 높이 01
                if (inRange(i + 1) && arr[i + 1] - arr[i] == 1) {
                    ans++;
                }
                // 높이 000
                if (inRange(i + 2) && arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2]) {
                    ans++;
                }
            }
        } else if (p == 6) { // 6번 블록
            for (int i = 0; i < n; i++) {
                if (inRange(i + 1) && arr[i] == arr[i + 1]) {
                    ans++;
                }
                if (inRange(i + 2) && arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2]) {
                    ans++;
                }
                if (inRange(i + 2) && arr[i + 1] - arr[i] == 1 && arr[i + 2] == arr[i + 1]) {
                    ans++;
                }
                if (inRange(i + 1) && arr[i] - arr[i + 1] == 2) {
                    ans++;
                }
            }
        } else if (p == 7) { // 7번 블록
            for (int i = 0; i < n; i++) {
                if (inRange(i + 1) && arr[i] == arr[i + 1]) {
                    ans++;
                }
                if (inRange(i + 2) && arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2]) {
                    ans++;
                }
                if (inRange(i + 2) && arr[i + 1] == arr[i] && arr[i + 1] - arr[i + 2] == 1) {
                    ans++;
                }
                if (inRange(i + 1) && arr[i + 1] - arr[i] == 2) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean inRange(int i) {
        return (i >= 0 && i < n);
    }
}
