package 알고리즘연습.codetree.투포인터;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @intuition 구간의 크기가 고정되어 있고, 중심을 잘 잡아 사탕의 수가 최대인 구간을 구하는 문제
 * 심지어, 사탕 수를 출력하는 거라서, 이건 sliding window에 가깝고 누적합으로 풀 수 있을듯
 * @algorithm prefix sum
 * @time O(N)
 * @memory O(N)
 */
public class 풀고있음_CodeTree_바구니안의사탕 {
    private static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 바구니 크기 - 최대 1_000_000
        K = Integer.parseInt(st.nextToken()); // 사탕 개수
        for (int i = 0; i < N; i++) {

        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
