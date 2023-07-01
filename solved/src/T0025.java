import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T0025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String ans1 = "";
        String ans2 = "";

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
                ans1 += s1.charAt(i);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) >= '0' && s2.charAt(i) <= '9') {
                ans2 += s2.charAt(i);
            }
        }
        int ans = Integer.parseInt(ans1) + Integer.parseInt(ans2);
        System.out.println(ans);
    }
}
