package 알고리즘연습.boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BOJ_16435_스네이크버드 {
    /*
    * 시간복잡도 : O(N & log N) // 정렬에 N * log N 소요
    *
    * 실행 시간 : 136 ms
    *
    * 메모리 : 14648 KB
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        for (int i : arr) {
            if (L < i) {
                break;
            }
            L++;
        }
        bw.write(String.valueOf(L));

        br.close();
        bw.flush();
        bw.close();
    }
}
