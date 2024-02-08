package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10974_모든순열 {
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 1; i <= n; i++) {
            arr[i-1] = i;
        }

        Arrays.stream(arr).forEach(e -> sb.append(e + " "));
        sb.append("\n");

        while (true) {
            if (!np(arr)) {
                break;
            }
        }

        System.out.println(sb);

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

        Arrays.stream(arr).forEach(e -> sb.append(e).append(" "));
        sb.append("\n");

        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
