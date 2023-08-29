package 코드트리.시뮬레이션.배열기록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 선두를지켜라 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        int v, t;
        aList.add(0);
        bList.add(0);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            if (t == 0) {
                aList.add(0);
            } else {
                for (int j = 1; j <= t; j++) {
                    aList.add(v*j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            if (t == 0) {
                bList.add(0);
            } else {
                for (int j = 1; j <= t; j++) {
                    bList.add(v * j);
                }
            }
        }
        int ans = 0;
        boolean isAFaster = false;
        for (int i = 1; i < aList.size(); i++) {
            if (i == 1) {
                isAFaster = aList.get(i) > bList.get(i);
            } else if (isAFaster != aList.get(i) > bList.get(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
