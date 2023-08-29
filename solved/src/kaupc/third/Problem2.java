package kaupc.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2 {
    private static int a,b,c;
    private static int p,q;
    private static int A, B, C, D;
    private static final int ROUND_NUM = 2;
    public static void main(String[] args) throws IOException {
        initCoef();
        /*
        P(X) - Q(X)의 판별식을 구해야 하고
        P(X) - Q(X)를 구하려면 그대로 전개하면 된다.
        */
        A = (a * p * p) - (a * p);
        B = (a * 2 * p * q + b * p) - (p * b);
        C = (a * q * q + b * q + c) - (p * c + q);
        if (A == 0 && B == 0 && C == 0) {
            System.out.println("Nice");
            return;
        } else {
            D = (B * B) - (4 * A * C);
            if (D > 0) {
                System.out.println("Go ahead");
            } else if (D == 0) {
                System.out.println("Remember my character");
            } else if (D < 0){
                System.out.println("Head on");
            }
        }


    }

    private static void initCoef() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < ROUND_NUM; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (i == 0) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
            } else {
                p = Integer.parseInt(st.nextToken());
                q = Integer.parseInt(st.nextToken());
            }
        }
    }

}
