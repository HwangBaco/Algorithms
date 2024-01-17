package 코드트리.완전탐색.기준설정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 가장_작은_X_찾기_틀림틀림틀림틀림틀림 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int a, b;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            for (int x = 1; x <= 10000; x++) {
                if (inRange(a, b, (int) (x * (Math.pow(2, i))))) {
                    set.add(x);
                } else {
                    set.remove(x);
                }
            }
        }
        System.out.println(set.first());
    }

    public static boolean inRange(int a, int b, int x) {
        return x >= a && x <= b;
    }
}
