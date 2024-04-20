package 알고리즘연습.swea.B형.코드배틀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2_이진수표현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int check = (1 << a) - 1;
            sb.append("#").append(i).append(" ").append((b & check) == check ? "ON" : "OFF").append("\n");
        }
        System.out.println(sb);
    }
}
