package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T0027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        br.close();
        int cnt = 0;
        while (true) {
            if (s1.equals(s2)) {
                break;
            } else if (cnt >= s1.length()) {
                cnt = -1;
                break;
            }
            s1 = s1.substring(s1.length()-1, s1.length()) + s1.substring(0,s1.length()-1);
            cnt++;

        }
        System.out.println(cnt);
    }
}
