package 알고리즘연습.boj;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10951_A더하기B4 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        while(s.hasNextInt()){
            int A = s.nextInt();
            int B = s.nextInt();
            System.out.println(A+B);
        }
    }
}
