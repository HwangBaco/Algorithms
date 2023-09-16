package 코드트리.완전탐색.백트래킹;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 특정조건에맞게_k개중에1개를_n번뽑기 {
    private static List<Integer> li = new ArrayList<>();
    private static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        go();
    }

    public static void go() {
        if (li.size() == n) {
            printNumbers();
            return;
        }
        for (int i = 1; i <= k; i++) {
            if (li.size() < 2 || !isDuplicate(i)) {
                li.add(i);
                go();
                li.remove(li.size() - 1);
            }
        }
    }

    private static boolean isDuplicate(int i) {
        return li.size() >= 2 && li.get(li.size() - 2) == li.get(li.size() - 1) && li.get(li.size() - 1) == i;
    }

    private static void printNumbers() {
        for (Integer i : li) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
