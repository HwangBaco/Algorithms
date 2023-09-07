package 코드트리.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 개념문제 {
    /*
    * 백트래킹은 재귀 함수를 이용하여 '순열과 조합'을 구현하는 거라고 이해하고 있으면 된다.
    * */

    /*
    * 문제 : k개 중에 1개를 n번 뽑기
    * */
    private static int n, k;
    private static List<Integer> li = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        choose(1);
    }

    private static void choose(int x) {
        if (x == n + 1) {
            print();
            return;
        }
        x++;
        for (int i = 1; i <= k; i++) {
            li.add(i);
            choose(x);
            li.remove(li.size() - 1);
        }
    }
    private static void print() {
        li.forEach(o -> System.out.print(o + " "));
        System.out.println();
    }

}
