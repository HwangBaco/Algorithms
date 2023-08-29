package 코드트리.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class 원_모양으로_되어있는_방 {
    private static int[] arr;
    private static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        arr = new int[n];
        ans = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int dist = j - i >= 0 ? j - i : j - i + n;
                ans[i] += arr[j] * dist;
            }
        }
        System.out.println(Arrays.stream(ans).min().orElseThrow(() -> new NoSuchElementException("")));
    }
}
