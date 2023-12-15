package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T0018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String cmp = br.readLine();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == cmp.charAt(0) && s.charAt(i + 1) == cmp.charAt(1)) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
