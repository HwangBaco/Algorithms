package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T0021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e') {
                idx = i;
                break;
            }
        }
        System.out.println(s.substring(0,idx) + s.substring(idx+1));
    }
}
