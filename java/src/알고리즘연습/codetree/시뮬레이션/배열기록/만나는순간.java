package 코드트리.시뮬레이션.배열기록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 만나는순간 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        String d;
        int t;
        int idx = 0;
        int jdx = 0;

        // initialize lists
        aList.add(0);
        bList.add(0);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            d = st.nextToken();
            t = Integer.parseInt(st.nextToken());
            if (d.equals("R")) {
                for (int j = 0; j < t; j++) {
                    aList.add(aList.get(idx++) + 1);
                }
            } else {
                for (int j = 0; j < t; j++) {
                    aList.add(aList.get(idx++) - 1);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            d = st.nextToken();
            t = Integer.parseInt(st.nextToken());
            if (d.equals("R")) {
                for (int j = 0; j < t; j++) {
                    bList.add(bList.get(jdx++) + 1);
                }
            } else {
                for (int j = 0; j < t; j++) {
                    bList.add(bList.get(jdx++) - 1);
                }
            }
        }
        br.close();
        boolean isNoAns = true;
        for (int i = 1; i < aList.size(); i++) {
            if (aList.get(i).equals(bList.get(i))) {
                System.out.println(i);
                isNoAns = false;
                break;
            }
        }
        if (isNoAns) {
            System.out.println(-1);
        }
    }
}
