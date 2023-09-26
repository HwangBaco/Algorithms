package 코드트리.완전탐색.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n개중에_m개뽑기 {
    private static int n, m;
    private static Set<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        go(1);


    }

    public static void go(int start) {
        if (set.size() == m) {
            set.forEach(e -> System.out.print(e + " "));
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            set.add(i);
            int next = i + 1;
            go(next);
            set.remove(i);
        }
    }
}
