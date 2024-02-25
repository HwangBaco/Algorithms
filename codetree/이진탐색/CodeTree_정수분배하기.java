package 알고리즘연습.codetree.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author HwangBaco
 * @algorithm
 * @time
 * @memory
 *
 * n개의 정수를 분배하여 같은 크기의 정수 k를 m개 만들려고 할 때,
 * 만들 수 있는 k값의 최댓값을 구하는 프로그램
 */
public class CodeTree_정수분배하기 {
    private static int[] arr;
    private static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정수의 개수
        m = Integer.parseInt(st.nextToken()); // 목표 수량
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        if (n == 1 && n < m) {
            System.out.println(0);
            return;
        } else if (n == 1 && n >= m) {
            System.out.println(n);
            return;
        } else {
            int ans = binarySearch();
            System.out.println(ans);
        }

    }

    private static int binarySearch() {
        int left = 0;
        int right = arr[n - 1];
        int num = 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int res = 0;
            for (int i : arr) {
                res += i / mid;
            }
            if (res >= m) {
                left = mid + 1;
                num = Math.max(num, mid);
            } else {
                right = mid - 1;
            }
        }
        return num;
    }
}
