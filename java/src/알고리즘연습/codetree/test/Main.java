package 코드트리.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static List<Integer> li = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        go(false);
    }

    private static void go(boolean hasPrevZero) {
        if (li.size() == n) {
            li.forEach(System.out::print);
            System.out.println();
            return;
        }
        for (int i = 1; i >= 0; i--) {
            if (hasPrevZero && i == 0) {
                li.add(1);
                go(false);
                li.remove(li.size() - 1);
            } else {
                if (i == 1) {
                    hasPrevZero = false;
                } else {
                    hasPrevZero = true;
                }
                li.add(i);
                go(hasPrevZero);
                li.remove(li.size() - 1);
            }
        }
    }
}
