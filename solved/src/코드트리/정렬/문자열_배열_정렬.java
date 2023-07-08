package 코드트리.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문자열_배열_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sArr = new String[n];
        for (int i = 0; i < n; i++) {
            sArr[i] = br.readLine();
        }
        Arrays.sort(sArr);
        for (int i = 0; i < n; i++) {
            System.out.println(sArr[i]);
        }
    }
}
