package 코드트리.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 흥미로운숫자2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int ans = 0;
        int res = 0;
        for (int i = x; i <= y; i++) {
            boolean flag = false;
            int[] arr = new int[10];
            res = i;
            while (res >= 1) {
                int n = res % 10;
                arr[n] += 1;
                res /= 10;
            }
            int length = String.valueOf(i).length();
            for (int j = 0; j < 10; j++) {
                if (arr[j] == length - 1) {
                    flag = true;
                }
            }
            if (flag) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
