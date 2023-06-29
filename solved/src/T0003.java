import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T0003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cntArr = new int[10];
        for (int i = 0; i < 10; i++) {
            cntArr[i] = 0;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while (true) {
            int n = a % b;
            a = a / b;
            cntArr[n] += 1;
            if (a <= 1) break;
        }
        int sum = Arrays.stream(cntArr).map(e -> e = e * e).reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
