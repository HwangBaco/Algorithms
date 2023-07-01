import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T0013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        br.close();

        int aLength = a.length();
        int bLength = b.length();
        int cLength = c.length();
        int[] arr = new int[3];
        arr[0] = aLength;
        arr[1] = bLength;
        arr[2] = cLength;

        Arrays.sort(arr);

        System.out.println(arr[2] - arr[0]);
    }
}
