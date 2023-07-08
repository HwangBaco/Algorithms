package 코드트리.시뮬레이션.구간칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class T001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int len;
        int idx = 100;
        int[] arr = new int[200];
        String command;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken());
            command = st.nextToken();
            if (command.equals("R")) {
                IntStream.range(idx, idx + len).forEach(j -> arr[j] += 1);
                idx += len;
            } else {
                IntStream.range(idx - len, idx).forEach(j -> arr[j] += 1);
                idx -= len;
            }
        }
        long count = Arrays.stream(arr).filter(i -> i >= 2).count();
        System.out.println(count);

    }
}
