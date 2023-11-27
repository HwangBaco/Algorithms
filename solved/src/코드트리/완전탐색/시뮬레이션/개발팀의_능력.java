package 코드트리.완전탐색.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개발팀의_능력 {
    // 시간제한 : 1000 ms (1초)
    // 공간제한 : 80 mb (int기준 n == 2천만)
    private static final int DEV_NUM = 5;
    private static int[] arr = new int[DEV_NUM];
    private static int sum = 0, a = 0, b = 0, c = 0;
    private static int minAns = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < DEV_NUM; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        for (int i = 0; i < DEV_NUM; i++) {
            for (int j = i+1; j < DEV_NUM; j++) {
                for (int k = 0; k < DEV_NUM; k++) {
                    for (int l = k+1; l < DEV_NUM; l++) {
                        checkMinAns(i, j, k, l);
                    }
                }
            }
        }
        if (minAns == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minAns);

        }
    }

    private static void checkMinAns(int i, int j, int k, int l) {
        if (i != k && i != l && j != k && j != l) {
            a = arr[i] + arr[j];
            b = arr[k] + arr[l];
            c = sum - b - a;
            if (a != b && b != c && a != c) {
                int abcMax = Math.max(Math.max(a, b), c);
                int abcMin = Math.min(Math.min(a, b), c);
                minAns = Math.min(minAns, abcMax - abcMin);
            }
        }
    }
}
