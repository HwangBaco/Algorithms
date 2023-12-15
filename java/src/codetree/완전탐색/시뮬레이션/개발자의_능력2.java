package 코드트리.완전탐색.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 개발자의_능력2 {
    // 시간제한 : 1000 ms (1초)
    // 공간제한 : 80 mb (int기준 n == 2천만)
    private static final int DEV_NUM = 6;
    private static int[] arr = new int[DEV_NUM];
    private static int sum = 0, a = 0, b = 0, c = 0;
    private static int minAns = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        for (int i = 0; i < 6; i++) {
            for (int j = i+1; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    for (int l = k+1; l < 6; l++) {
                        checkMinAns(i, j, k, l);
                    }
                }
            }
        }
        System.out.println(minAns);
    }

    private static void checkMinAns(int i, int j, int k, int l) {
        if (i != k && i != l && j != k && j != l) {
            a = arr[i] + arr[j];
            b = arr[k] + arr[l];
//            System.out.println("arr[i] = " + arr[i]);
//            System.out.println("arr[j] = " + arr[j]);
//            System.out.println("arr[k] = " + arr[k]);
//            System.out.println("arr[l] = " + arr[l]);
            c = sum - b - a;
//            System.out.println("sum = " + sum);
            int abcMax = Math.max(Math.max(a, b), c);
            int abcMin = Math.min(Math.min(a, b), c);
            minAns = Math.min(minAns, abcMax - abcMin);
        }
    }
}
