package 코드트리.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 오름차순_내림차순 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 내림차순
        Integer[] _arr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(_arr, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            System.out.print(_arr[i] + " ");
        }

    }
}
