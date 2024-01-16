package 코드트리.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T0001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr_A = new int[n];
        for (int i = 0; i < n; i++) {
            arr_A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] arr_B = new int[n];
        for (int i = 0; i < n; i++) {
            arr_B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr_A);
        Arrays.sort(arr_B);
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (arr_A[i] != arr_B[i]) {
                flag = false;
                break;
            }
        }
        System.out.println(flag? "Yes" : "No");

    }
}
