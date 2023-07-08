package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {
    static int n, m;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = (n-1); i >= 0; i--) {
            if (m <= 0) {
                break;
            }
            if (arr[i] <= m) {
                while (arr[i] <= m) {
                   m -= arr[i];
                   cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
