package 코드트리.자료구조_중급.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 자리_차지하기 {
    public static void main(String[] args) throws IOException {
        /*
        자리를 빼버리면 그만인 문제이므로
        1 ~ m까지의 숫자를 treeSet에 넣어둔 뒤에,
        주어지는 숫자 k를 floor(k)로 하여 null이 아니면 cnt++; 한다.
        null이면 print(cnt)하고 break; 한다.
        **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();
        initTreeSet(m, set);

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (set.floor(v) != null) {
                set.remove(set.floor(v));
                cnt++;
            } else {
                System.out.println(cnt);
                return;
            }
        }
        System.out.println(cnt);
    }

    private static void initTreeSet(int m, TreeSet<Integer> set) {
        for (int i = 1; i <= m; i++) {
            set.add(i);
        }
    }
}
