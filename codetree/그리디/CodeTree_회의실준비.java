package 알고리즘연습.codetree.그리디;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CodeTree_회의실준비 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        String ans = solution(n, arr);

        bw.write(ans);

        br.close();
        bw.flush();
        bw.close();
    }

    private static String solution(int n, int[][] arr) {
        final int START = 0;
        final int END = 1;

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[END] == o2[END]) {
                return o1[START] - o2[START];
            }
            return o1[END] - o2[END];
        });

        int cnt = 0;
        int prevEnd = 0;
        for (int[] meeting : arr) {
            if (prevEnd <= meeting[START]) {
                prevEnd = meeting[END];
                cnt++;
            }
        }

        return String.valueOf(cnt);
    }

}
