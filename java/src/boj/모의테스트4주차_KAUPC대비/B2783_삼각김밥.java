package 백준.모의테스트4주차_KAUPC대비;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class B2783_삼각김밥 {
    public static int n;
    public static double x,y;
    public static double[] res;
    public static void main(String[] args) throws IOException {
        /*
        x * 1000 / y를 배열에 입력
        **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        res = new double[n+1];
        res[0] = x * 1000 / y;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());
            res[i] = x * 1000 / y;
        }
        double ans = Arrays.stream(res).min().orElseThrow(() -> new NoSuchElementException(""));
        System.out.printf("%.2f", ans);
    }
}
