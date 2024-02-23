package 알고리즘연습.boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author HwangBaco
 * @algorithm combination
 * @time O(2^N)
 *
 * 그냥 순서대로 문자를 조합해서 정렬시키면 되는 문제
 */
public class BOJ_1759_암호만들기 {
    private static int L; // 암호의 길이
    private static int C; // 문자 종류의 개수
    private static char[] chars;
    private static char[] codes;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        codes = new char[L];
        chars = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);

        comb(0, 0, 0, 0);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void comb(int cnt, int start, int vowCnt, int consCnt) {
        if (cnt == L) {
            if (vowCnt > 0 && consCnt > 1) {
                sb.append(codes).append("\n");
            }
            return;
        }
        for (int i = start; i < C; i++) {
            codes[cnt] = chars[i];
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                comb(cnt + 1, i + 1, vowCnt + 1, consCnt);
            } else {
                comb(cnt + 1, i + 1, vowCnt, consCnt + 1);
            }
        }
    }
}
