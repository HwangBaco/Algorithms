package 알고리즘연습.codetree.투포인터;

import java.io.*;
import java.util.StringTokenizer;

public class CodeTree_부분수열여부판단하기 {
    private static int N, M;
    private static int[] arr, brr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        brr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }

        String ans = "Yes";
        int i = 0;
        for (int j = 0; j < M; j++) {
            while (i < N && arr[i] != brr[j]) {
                i++;
            }
            if (i == N) { // 이미 부분수열이 아닌게 결정된 경우
                ans = "No";
                break;
            }
            if (j == M - 1 && i < N) {
                break;
            }
        }
        sb.append(ans);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
