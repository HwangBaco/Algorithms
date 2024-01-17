package 알고리즘연습.codetree.완전탐색.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 거꾸로_순열 {

    /*
    * 시간복잡도 : O(n!) - 문제에서는 n이 최대 8이므로 가능
    * */
    static List<Integer> li;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        li = new ArrayList<>();
        go(n, new boolean[n + 1]);
    }

    static void go(int n, boolean[] selected) {
        if (li.size() == n) {
            li.stream().forEach(i -> System.out.print(i + " "));
            System.out.println();
            return;
        }
        for (int i = n; i > 0; i--) {
            if (!selected[i]) {
                selected[i] = true;
                li.add(i);
                go(n, selected);
                selected[i] = false;
                li.remove(li.size() - 1);
            }
        }

    }
}
