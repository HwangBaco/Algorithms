import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T0002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());
        int[] arr = new int[10];
        arr[0] = one;
        arr[1] = two;
        for (int i = 2; i < 10; i++) {
            arr[i] = arr[i-1] + 2*arr[i-2];
        }
//        for (int i :
//                arr) {
//            System.out.print(i + " ");
//        }
        Arrays.stream(arr).forEach(o -> System.out.print(o + " "));
    }
}
