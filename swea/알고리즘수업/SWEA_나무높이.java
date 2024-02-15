package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_나무높이 {
    /*
     * 인근 천재의 풀이 참고함
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int max = -1;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
                max = Math.max(max, num);
            }

            int total = 0;
            int totalOddCnt = 0;
            for (int i : arr) {
                if (i == max) {
                    continue;
                }
                int sub = max - i;
                total += sub;
                totalOddCnt += sub % 2;
            }

            // 1,2,1,2, ... 이상적으로 자라는 경우
            int res = ((total / 3) << 1) + (total % 3);

            int resOddCnt = res / 2 + res % 2; // 이상적으로 자랐을 때의 1 개수

            if (resOddCnt >= totalOddCnt) {
                System.out.printf("#%d %d\n", tc, res);
                continue;
            }
            /*
            * 만약 전체 카운트 중 홀수의 개수가 이상적인 경우의 홀수 카운트보다 많을 경우
            * 즉, 격일로 자라야 하는 경우에는 어차피 2일에 하나 처리해야 하니까 2인 애들은 알아서 홀수 사이 공간에 껴서 크는거니까 홀수만 신경쓰면 됨.
            * */
            System.out.printf("#%d %d\n", tc, (totalOddCnt * 2 - 1));
        }

    }
}
