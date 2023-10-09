package 코드트리.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class backtracking2 {
    private static List<Integer> li = new ArrayList<>();
    private static List<String> ans = new ArrayList<>();
    private static int n;
    public static void main(String[] args) throws IOException {
        /*
        * 1,2,3 만 사용해서 만들 수 있는 숫자 중 1,2가 모두 세 번 이상 나타나는 n자리 수를 출력
        * n자리 수를 만드는 li<Integer> 선언
        * 1,2가 모두 세 번 이상인지는 파라미터로 넘김
        *
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        go(0, 0);
        ans.forEach(System.out::println);
    }

    private static void go(int one, int two) {
        if (li.size() == n) {
            if (one >= 3 && two >= 3) {
                StringBuffer sb = new StringBuffer("");
                for (int i : li) {
                    sb.append(i);
                }
                String s = sb.toString();
                ans.add(s);
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            li.add(i);
            if (i == 1) {
                one++;
            } else if (i == 2) {
                two++;
            }
            go(one, two);
            if (i == 1) {
                one--;
            } else if (i == 2) {
                two--;
            }
            li.remove(li.size() - 1);
        }
    }
}
