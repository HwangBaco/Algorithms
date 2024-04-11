package 알고리즘연습.codetree.시간단축.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeTree_숫자의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            int v = Integer.parseInt(br.readLine());
            int lb = getLowerBound(arr, v);
            int up = getUpperBound(arr, v);
            if (lb < 0 || up < 0) {
                sb.append("0\n");
                continue;
            }
            sb.append((up - lb + 1) + "\n");
        }
        System.out.println(sb);
    }

    private static int getLowerBound(int[] arr, int v) {
        int left = 0;
        int right = arr.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > v) {
                right = mid - 1;
            } else if (arr[mid] < v) {
                left = mid + 1;
            } else {
                break;
            }
        }
        if (right < left) {
            return -1;
        }

        while (mid >= 0 && arr[mid] == v) {
            mid--;
        }
        return mid + 1;
    }

    private static int getUpperBound(int[] arr, int v) {
        int left = 0;
        int right = arr.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > v) {
                right = mid - 1;
            } else if (arr[mid] < v) {
                left = mid + 1;
            } else {
                break;
            }
        }
        if (right < left) {
            return -1;
        }
        while (mid < arr.length && arr[mid] == v) {
            mid++;
        }
        return mid-1;
    }
}
