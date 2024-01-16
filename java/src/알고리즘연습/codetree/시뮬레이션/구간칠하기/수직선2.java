package 코드트리.시뮬레이션.구간칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 수직선2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[200];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) + 100;
            int b = Integer.parseInt(st.nextToken()) + 100;
            IntStream.range(a, b).forEach(j -> arr[j] += 1);
        }
        Arrays.stream(arr).forEach(System.out::print);
        int ans = Arrays.stream(arr).max().orElseThrow(() -> new NoSuchElementException("원소 없음"));
        System.out.println(ans);
    }
}
