package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_백설공주와일곱난쟁이 {
    static short ans;
    public static void main(String[] args) throws IOException {
        /**
         * memory : 14312 KB
         * time : 140 ms
         * logic : 단순 조합
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
        }

        go(arr, 0, 0, (short) 0);

        for (int i = 0; i < 9; i++) {
            if ((ans & (1 << i)) != 0) {
                System.out.println(arr[i]);
            }
        }
    }

    private static void go(int[] arr, int sum, int cnt, short visited) {
        if (cnt == 7 && sum == 100) {
            ans = visited;
            return;
        }
        for (int i = 0; i < 9; i++) {
            if ((visited & (1 << i)) != 0 || sum + i > 100) {
                continue;
            }
            sum += arr[i];
            cnt++;
            go(arr, sum, cnt, (short) (visited | 1 << i));
            sum -= arr[i];
            cnt--;
        }
    }
}
