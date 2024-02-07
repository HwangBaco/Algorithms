package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H1 = Integer.parseInt(st.nextToken());
        int W1 = Integer.parseInt(st.nextToken());
        int[] arr = new int[H1];
        int aCount = 0;
        for (int i = 0; i < H1; i++) {
            String s = br.readLine();
            for (int j = 0; j < W1; j++) {
                if (s.substring(j, j + 1).equals("O")) {
                    arr[i] |= 1 << j;
                    aCount++;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int H2 = Integer.parseInt(st.nextToken());
        int W2 = Integer.parseInt(st.nextToken());
        int[] brr = new int[H2];
        for (int i = 0; i < H2; i++) {
            String s = br.readLine();
            for (int j = 0; j < W2; j++) {
                if (s.substring(j, j + 1).equals("O")) {
                    brr[i] |= 1 << j;
                }
            }
        }
        int ans = (int) 1e9;
        for (int i = 0; i < H1; i++) {
            for (int j = 0; j < W1; j++) {
                int res = aCount;
                for (int k = i; k < i + H2; k++) {
                    for (int l = j; l < j + W2; l++) {
                        if (k < H1 && l < W1) { // 기본 조건
                            if ((arr[k] & 1 << l) != 0 && (brr[k - i] & 1 << (l - j)) != 0) {
                                res--;
                            }
                        }
                    }
                }

                ans = Math.min(ans, res);
            }
        }
        System.out.println(ans);
    }
}
