package 알고리즘연습.codetree.그리디;

import java.io.*;
import java.util.Arrays;

public class CodeTree_최대숫자만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        String ans = solution(arr);

        bw.write(ans);
        br.close();
        bw.flush();
        bw.close();
    }

    private static String solution(Integer[] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            String s1 = Integer.toString(o1) + Integer.toString(o2);
            String s2 = Integer.toString(o2) + Integer.toString(o1);
            return s2.compareTo(s1);
        });

        StringBuffer sb = new StringBuffer();
        for (Integer i : arr) {
            sb.append(i);
        }

        return sb.toString();
    }

}
