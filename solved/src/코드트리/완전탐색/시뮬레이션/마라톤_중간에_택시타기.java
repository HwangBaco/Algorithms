package 코드트리.완전탐색.시뮬레이션;

import java.io.*;
import java.util.*;

public class 마라톤_중간에_택시타기 {
    private static List<Integer> xList = new ArrayList<>();
    private static List<Integer> yList = new ArrayList<>();
    private static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ans = new int[n-2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xList.add(x);
            yList.add(y);
        }
        br.close();

        for (int i = 1; i < n - 1; i++) {
            Integer removeX = xList.remove(i);
            Integer removeY = yList.remove(i);
            for (int j = 1; j < n-1; j++) {
                int resX = Math.abs(xList.get(j) - xList.get(j - 1));
                int resY = Math.abs(yList.get(j) - yList.get(j - 1));
                ans[i - 1] += resX + resY;
            }
            xList.add(i, removeX);
            yList.add(i, removeY);
        }
//        Arrays.stream(ans).forEach(System.out::print);
        System.out.println(Arrays.stream(ans).min().orElseThrow(()-> new NoSuchElementException("")));

    }
}
