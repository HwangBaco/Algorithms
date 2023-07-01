import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T0016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        char[] arr = new char[temp.length() / 2];
        int idx = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (i % 2 == 1) {
                arr[idx++] = temp.charAt(i);
            }
        }
        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}
