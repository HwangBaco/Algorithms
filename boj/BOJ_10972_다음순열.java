package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class BOJ_10972_다음순열 {
    /*
    * 기본 연습문제
    * 
    * time complexity : O(N!)
    *
    * 실행 시간 : 372 ms
    *
    * 메모리 : 18116 KB
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean np = np(arr);
        if (np) {
            Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
            return;
        }
        System.out.println(-1);
    }

    private static boolean np(int[] arr) {
        final int LAST_IDX = arr.length - 1;

        int i = LAST_IDX;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            --i;
        }

        if (i == 0) {
            return false;
        }

        int j = LAST_IDX;
        while (arr[i - 1] >= arr[j]) {
            --j;
        }

        swap(arr, i - 1, j);

        int k = LAST_IDX;
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
