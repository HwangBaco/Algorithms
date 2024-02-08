package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class SWEA_준환이의양팔저울 {
    /*
    * 수행 시간 : 880 ms
    * */
    private static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            int n = Integer.parseInt(br.readLine());
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ans = 0;
            Arrays.sort(arr);
            powerSet(arr, 0, arr.length, 0 ,0);

            while (true) {
                if (!np(arr)) {
                    break;
                }
            }

            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    public static boolean np(int[] arr) {
        final int LI = arr.length - 1; // last index

        int i = LI;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            --i;
        }

        if (i == 0) {
            return false;
        }

        int j = LI;
        while (arr[i - 1] >= arr[j]) {
            --j;
        }

        swap(arr, i - 1, j);

        int k = LI;
        while (i < k) {
            swap(arr, i++, k--);
        }

        powerSet(arr, 0, arr.length, 0, 0);

        return true;
    }

    public static void powerSet(int[] arr, int depth, int n, int leftSum, int rightSum) {
        if (depth == n) {
            ans++;
            return;
        }

        if (rightSum + arr[depth] <= leftSum) {
            powerSet(arr, depth+1, n, leftSum, rightSum + arr[depth]);
        }
        powerSet(arr, depth+1, n, leftSum + arr[depth], rightSum);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
