package 알고리즘연습.codetree.legacy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author HwangJecheol
 *
 * input:
 * n : 처음 놓여있는 블럭의 수 (2 이상, 100 이하)
 * n개의 수 : 1 이상 100 이하
 * s, e: (위에서부터) 제거할 블럭의 구간 정보 (등호 포함)
 *
 * output:
 * 남은 블록의 개수
 * 남은 블록들
 */
public class CodeTree_1차원젠가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] blocks = new int[n+1];
        StringTokenizer st;
        int[] temp = new int[n+1];
        int endIdx = 1;
        for (int i = 1; i <= n; i++) {
            blocks[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 날라가는 블록 삭제
            for (int j = s; j <= e; j++) {
                blocks[j] = -1;
            }
            // 임시 배열에 남은 블록만 복사
            for (int j = 1; j <= n; j++) {
                if (blocks[j] != -1) {
                    temp[endIdx++] = blocks[j];
                }
            }
            // blocks 배열 renew
            for (int j = 1; j <= n; j++) {
                if (temp[j] > 0) {
                    blocks[j] = temp[j];
                    temp[j] = 0;
                    continue;
                }
                temp[j] = 0;
                blocks[j] = 0;
            }
            endIdx = 1;
        }
        StringBuffer sb = new StringBuffer();
        long count = Arrays.stream(blocks).filter(i -> i != 0).count();
        sb.append(count).append("\n");
        Arrays.stream(blocks).filter(i -> i != 0).forEach(e -> sb.append(e + "\n"));
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
