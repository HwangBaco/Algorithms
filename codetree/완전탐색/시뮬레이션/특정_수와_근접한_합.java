package 코드트리.완전탐색.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정_수와_근접한_합 {
    private static int[] arr;
    private static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int save1 = arr[i];
                arr[i] = 0;
                int save2 = arr[j];
                arr[j] = 0;
                int sum = Arrays.stream(arr).sum();
                ans.add(Math.abs(sum - s));
                arr[i] = save1;
                arr[j] = save2;
            }
        }
        System.out.println(ans.stream().mapToInt(i->i).min().orElseThrow(()->new NoSuchElementException("")));
    }
}
