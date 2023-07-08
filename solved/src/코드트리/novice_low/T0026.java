package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T0026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int temp = 0;
        String ans;
        for (int i = 0; i < n; i++) {
            temp += Integer.parseInt(br.readLine());
        }
        ans = Integer.toString(temp).substring(1) + Integer.toString(temp).substring(0, 1);
        System.out.println(ans);
    }
}
