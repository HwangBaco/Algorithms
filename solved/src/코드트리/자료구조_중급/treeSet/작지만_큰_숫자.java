package 코드트리.자료구조_중급.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 작지만_큰_숫자 {
    /*
    n 개의 숫자로 이루어진 수열이 하나 주어지고, 그 이후 m개의 질의가 주어진다.
    주어진 숫자 k보다 같거나 작은 숫자들 중 최댓값을 제거, 없으면 pass
    -> 대놓고 treeset 문제
    **/
    private static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            Integer findValue = set.floor(cmd);
            if (findValue != null) {
                System.out.println(set.floor(findValue));
                set.remove(findValue);
            } else {
                System.out.println(-1);
            }
        }


    }
}
