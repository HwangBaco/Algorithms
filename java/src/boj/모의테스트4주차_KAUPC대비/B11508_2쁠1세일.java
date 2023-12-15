package 백준.모의테스트4주차_KAUPC대비;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.stream.Stream;

/*
        Integer[] _arr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(_arr, Collections.reverseOrder());
**/

public class B11508_2쁠1세일 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Integer[] _arr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(_arr, Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 != 2) {
                ans += _arr[i];
            }
        }
        System.out.println(ans);
    }
}
