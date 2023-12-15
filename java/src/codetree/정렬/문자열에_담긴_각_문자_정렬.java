package 코드트리.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문자열에_담긴_각_문자_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < s.length(); i++) {
            System.out.print(chars[i]);
        }
    }
}
