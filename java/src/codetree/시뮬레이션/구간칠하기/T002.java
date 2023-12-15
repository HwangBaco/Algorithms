package 코드트리.시뮬레이션.구간칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class T002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[1000*100*2];
        int curIdx = 1000*100-1;
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            if (b.equals("R")) {
                IntStream.rangeClosed(curIdx, curIdx + a - 1).forEach(j -> arr[j] = "b" + arr[j]);
                curIdx += a - 1;
            } else {
                IntStream.rangeClosed(curIdx - a + 1, curIdx).forEach(j -> arr[j] = "w" + arr[j]);
                curIdx -= a - 1;
            }
        }
        br.close();
        long white = 0;
        long black = 0;
        long gray = 0;
        white += Arrays.stream(arr).filter(i -> i != null && i.substring(0,1).equals("w"))
                .filter(i -> i.chars()
                        .filter(c -> c == 'w')
                        .count() < 2
                        ||
                        i.chars()
                                .filter(c -> c == 'b')
                                .count() < 2)
                .count();
        black += Arrays.stream(arr)
                .filter(i -> i != null && i.substring(0,1).equals("b"))
                .filter(i -> i.chars()
                        .filter(c -> c == 'w')
                        .count() < 2
                        ||
                        i.chars()
                                .filter(c -> c == 'b')
                                .count() < 2)
                .count();
        gray += Arrays.stream(arr)
                .filter(i -> i != null)
                .filter(i -> i.chars()
                        .filter(c -> c == 'w')
                        .count() >= 2
                        &&
                        i.chars()
                        .filter(c -> c == 'b')
                        .count() >= 2)
                .count();
        System.out.printf("%d %d %d", white, black, gray);
    }
}
/*
* bw bwb bwb wbwb wbwb wb wb
**/
/*
* bbww wb
**/
/*
*
4
12 R
1 L
1 L
1 L
* * */
