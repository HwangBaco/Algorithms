package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물_COPY {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;

        for (int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = w - 1;
            for (int j = 0; j <= i; j++) {
                left = arr[left] > arr[j] ? left : j;
            }
            for (int j = i; j < w; j++) {
                right = arr[right] > arr[j] ? right : j;
            }
            int std = Math.min(arr[left], arr[right]);
            res += std - arr[i];
        }

        System.out.println(res);
    }
}
