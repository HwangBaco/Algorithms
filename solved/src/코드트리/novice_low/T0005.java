package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T0005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        boolean flag = false;
        int idx = 0;
        for (int i = 0; i < n1; i++) {
            if (arr1[i] == arr2[0]) {
                for (int j = i; j < i+n2; j++) {
                    if (i + n2 > n1) {
                        break;
                    }
                    if (arr1[j] == arr2[idx++]) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            idx = 0;
            if (flag) {
                System.out.println("YES");
                break;
            }
        }
        if (!flag) {
            System.out.println("NO");
        }

    }
}
