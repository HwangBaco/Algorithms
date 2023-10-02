package 코드트리.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class backtracking {
    private static int n;
    private static List<Integer> li = new ArrayList<>();
    private static List<String> ansList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        /*
         * 1~3 사용해서 만들 수 있는 숫자들 중 1,2가 모두 세 번 이상 나타나는 n자리 수를 순서대로 출력
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        go(0,0);
        ansList.forEach(System.out::println);
    }

    private static void go(int cnt1, int cnt2) {
        if (li.size() == n) {
            if (cnt1 >= 3 && cnt2 >= 3) {
                StringBuffer sb = new StringBuffer();
                li.forEach(sb::append);
                String ans = sb.toString();
                ansList.add(ans);
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            li.add(i);
            if (i == 1) {
                cnt1++;
            } else if (i == 2) {
                cnt2++;
            }
            go(cnt1, cnt2);
            li.remove(li.size() - 1);
            if (i == 1) {
                cnt1--;
            } else if (i == 2) {
                cnt2--;
            }
        }
    }
}
