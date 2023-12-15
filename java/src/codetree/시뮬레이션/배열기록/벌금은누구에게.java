package 코드트리.시뮬레이션.배열기록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벌금은누구에게 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int t;
        boolean isAns = false;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            arr[t-1] += 1;
            if (arr[t - 1] == k) {
                System.out.println(t);
                isAns = true;
                break;
            }
        }
        if (!isAns) {
            System.out.println(-1);
        }

    }
}
