package 코드트리.완전탐색.백트래킹;

import java.io.*;
import java.util.*;

public class 겹치지않게_선분고르기 {
    private static class Line {
        private int a;
        private int b;

        public int getA() {
            return this.a;
        }

        public int getB() {
            return this.b;
        }

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    private static final int X_RANGE = 1001;

    private static int n;
    private static int[] arr = new int[X_RANGE];
    private static Map<Integer, Line> m = new HashMap<>();
    private static boolean stop = false;

    private static List<Line> li = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Line l = new Line(a, b);
            m.put(i, l);
        }

        for (int i = n; i > 0 ; i--) {
            // i : 몇 개의 라인을 고를 것인가?
            arr = new int[X_RANGE];
            go(i, 0);
        }
        if (!stop) {
            System.out.println(0);
        }

        /*
        * 몇 개의 라인을 고를건지 for loop으로 완전탐색
        * */

        /*
        * 골랐으면 재귀 깊이가 그 정도에서 멈출 수 있게 함
        * */

        /*
        * 정해졌으면 재귀를 돌려서 line 조합을 선정 -> 각 조합에 대한 정답 검사를 탈출 조건에서 수행.
        * */



    }

    public static void go(int i, int j) {
        if (stop) {
            return;
        }
        if (li.size() == i) {
            if (isDistinct(li)) {
                System.out.println(i);
                stop = true;
            }
            arr = new int[X_RANGE];
            return;
        }

        for (int k = j; k < n; k++) {
            li.add(m.get(k));
            go(i, ++j);
            li.remove(li.size() - 1);
        }
    }

    public static boolean isDistinct(List<Line> li) {
        for (Line line : li) {
            int a = line.getA();
            int b = line.getB();
            for (int i = a; i <= b; i++) {
                arr[i] += 1;
            }
        }
        for (int i : arr) {
            if (i > 1) {
                return false;
            }
        }
        return true;
    }


}
