package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T0040 {
    private static int[] arr;
    private static int n;
    private static int ans = 1;
    private static int idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(f(ans, arr[idx]));


    }

    private static int f(int ans, int num) {
        for (int i = 1; i <= num; i++) {
            int temp = ans;
            temp *= i;
            if (temp % num == 0) {
                ans = temp;
                break;
            }
        }
        if ((idx+1) == n) {
            return ans;
        } else {
            return f(ans, arr[++idx]);
        }
    }

}
