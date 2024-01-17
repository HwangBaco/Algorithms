package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T0020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char one = s.charAt(0);
        char two = s.charAt(1);
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == two) {
                ans += one;
            } else {
                ans += s.charAt(i);
            }
        }
        System.out.println(ans);
    }
}
