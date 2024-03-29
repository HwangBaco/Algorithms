package 알고리즘연습.codetree.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_1이k개이상존재하는부분수열 {
    private static int[] arr;
    private static int[] cntarr = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int j = 0;
        int min = (int) 1e9;
        cntarr[arr[0]]++;
        for (int i = 0; i < n; i++) {
            while (j + 1 < n && cntarr[1] < k) {
                cntarr[arr[++j]]++;
            }
            if (cntarr[1] >= k) {
                min = Math.min(j - i + 1, min);
            }
            if (j == n - 1) {
                break;
            }
            cntarr[arr[i]]--;
        }
        System.out.println(min == (int) 1e9 ? -1 : min);
    }
}
