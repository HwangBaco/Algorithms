package 알고리즘연습.codetree.twopointer;

import java.io.*;
import java.util.*;

public class CodeTree_가장짧은부분합 {
    private static int N, S;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int ans = (int) 1e9;
        int j = 0;
        for (int i = 0; i < N; i++) {
            while (j < N && sum < S) {
                sum += arr[j];
                j++;
            }
            if (sum < S) {
                break;
            }
            ans = Math.min(ans, j - i);
            sum -= arr[i];
        }
        System.out.println(ans == (int) 1e9 ? -1 : ans);
    }
}
