package 코드트리.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 아름다운_수열2 {
    private static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /*
        수열 A는 N개의 숫자로
        수열 B는 M개의 숫자로 이루어짐

        -> 수열 A 중에서 슬라이딩 윈도우(크기 M)로 탐색하여 B의 요소들로 구성된 경우를 센다.

        1. A와 B 수열을 전부 입력받고,
        2. A를 슬라이딩 윈도우로 iteration한다.
        3. 구간별로 수열 B의 요소들을 모두 가지고 있을 경우, cnt++;
        **/
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] brr = new int[m];
        int[] check = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
            System.out.print(brr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n-m; i++) {
            for (int j = i; j < i+m; j++) {
                for (int k = 0; k < m; k++) {
                    if (check[k] == 0 && arr[j] == brr[k]) {
                        System.out.println("i = " + i);
                        System.out.println("j = " + j);
                        System.out.println("k = " + k);
                        System.out.println("arr[j] = " + arr[j]);
                        System.out.println("brr[k] = " + brr[k]);
                        check[k] = 1;
                    }
                }
            }
            long cnt = Arrays.stream(check).filter(e -> e > 0).count();
            if (cnt == 0) {
                ans++;
            }
            check = new int[m];
        }
        System.out.println(ans);
    }
}
