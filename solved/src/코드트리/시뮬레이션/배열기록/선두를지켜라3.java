package 코드트리.시뮬레이션.배열기록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 선두를지켜라3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /*
        1. 달랐다가 만난 경우
        2. 만났다가 달라진 경우
        3. 달랐다가 역전된 경우

        위 세가지 경우를 카운트 :: 출력
         */
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v, t;
        List<Integer> aLi = new ArrayList<>();
        List<Integer> bLi = new ArrayList<>();
        aLi.add(0);
        bLi.add(0);
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            for (int j = 0; j < t; j++) {
                a += v;
                aLi.add(a);
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            for (int j = 0; j < t; j++) {
                b += v;
                bLi.add(b);
            }
        }
        int ans = 0;
        for (int i = 1; i < aLi.size(); i++) {
            if (aLi.get(i).equals(bLi.get(i)) && !aLi.get(i - 1).equals(bLi.get(i - 1))) {
                ans++;
            } else if (!aLi.get(i).equals(bLi.get(i)) && aLi.get(i - 1).equals(bLi.get(i - 1))) {
                ans++;
            } else if ((int) aLi.get(i) > (int) bLi.get(i) && (int) aLi.get(i - 1) < (int) bLi.get(i - 1)) {
                ans++;
            } else if ((int) aLi.get(i) < (int) bLi.get(i) && (int) aLi.get(i - 1) > (int) bLi.get(i - 1)) {
                ans++;
            }
        }
//        aLi.stream().forEach(System.out::print);
//        System.out.println();
//        bLi.stream().forEach(System.out::print);
//        System.out.println();
        System.out.println(ans);
    }
}
