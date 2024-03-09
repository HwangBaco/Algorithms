package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_15666_N과M12 {
    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        String prev = "";
        do {
            sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            if (!prev.equals(sb.toString())) {
                System.out.println(sb.toString());
                prev = sb.toString();
            }
        } while(np(arr));
    }

    private static boolean np(int[] arr) {
        sb = new StringBuilder();
        final int LI = arr.length - 1;

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

        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
