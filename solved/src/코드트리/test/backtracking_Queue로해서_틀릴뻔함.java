package 코드트리.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backtracking_Queue로해서_틀릴뻔함 {
    private static int n;
    private static List<Integer> li = new LinkedList<>();
    private static List<String> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        go(0, 0, 0);
        ans.forEach(System.out::println);
    }

    private static void go(int oneCnt, int twoCnt, int threeCnt) {
        if (li.size() == n) {
            if (oneCnt <= twoCnt && twoCnt <= threeCnt) {
                StringBuilder sb = new StringBuilder("");
                li.forEach(sb::append);
                ans.add(sb.toString());
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            li.add(i);
            if (i == 1) {
                oneCnt++;
            } else if (i == 2) {
                twoCnt++;
            } else {
                threeCnt++;
            }
            go(oneCnt, twoCnt, threeCnt);
            li.remove(li.size() - 1);
            if (i == 1) {
                oneCnt--;
            } else if (i == 2) {
                twoCnt--;
            } else {
                threeCnt--;
            }
        }
    }

}
