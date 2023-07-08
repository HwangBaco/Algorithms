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
        double[] arr = new double[1000*100*2];
        int curIdx = 1000*100;
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            if (b.equals("R")) {
                IntStream.rangeClosed(curIdx, curIdx + a - 1).forEach(j -> arr[j] += 1);
                curIdx += a;
            } else {
                IntStream.rangeClosed(curIdx - a + 1, curIdx).forEach(j -> arr[j] += 1);
                curIdx -= a;
            }
        }
        long white = 0;
        long black = 0;
        long gray = 0;
        white += Arrays.stream(arr).limit(1000 * 100).filter(i -> i % 2 == 1 && i < 4).count();
        white += Arrays.stream(arr).skip(1000 * 100).filter(i -> i % 2 == 0 && i < 4 && i > 0).count();
        black += Arrays.stream(arr).limit(1000 * 100).filter(i -> i % 2 == 0 && i < 4 && i > 0).count();
        black += Arrays.stream(arr).skip(1000 * 100).filter(i -> i % 2 == 1 && i < 4).count();
        gray += Arrays.stream(arr).filter(i -> i >= 4).count();
        System.out.printf("%d %d %d", white, black, gray);
    }
}
