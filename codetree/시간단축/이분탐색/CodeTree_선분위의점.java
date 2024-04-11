package 알고리즘연습.codetree.시간단축.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeTree_선분위의점 {
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

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a는 그것보다 크거나 같은 숫자의 좌표를 반환
            // b는 그것보다 작거나 같은 숫자의 좌표를 반환
            // b-a+1 출력
            int aub = getLowerBound(arr, a);
            System.out.println("aub = " + aub);
            int blb = getUpperBound(arr, b);
            System.out.println("blb = " + blb);
            int res = blb - aub;
            sb.append(res < 0 ? 0 : res + 1).append("\n");
        }
        System.out.println(sb);
    }

    private static int getLowerBound(int[] arr, int v) {
        int left = 0;
        int right = arr.length - 1;
        int ans = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= v) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private static int getUpperBound(int[] arr, int v) {
        int left = 0;
        int right = arr.length - 1;
        int ans = left;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= v) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
