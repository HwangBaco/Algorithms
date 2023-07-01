import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T0024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 90) {
                ans += (char) ((int) s.charAt(i) + 32);
            } else {
                ans += (char)((int) s.charAt(i) -32);
            }
        }
        System.out.println(ans);
    }
}
