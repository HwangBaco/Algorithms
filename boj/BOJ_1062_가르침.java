package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1062_가르침 {
    /**
     * memory : 442100KB
     *
     * time : 2892 ms
     *
     * logic : 비트마스킹 이용하여 주어진 문자 저장하고 탐색
     */

    public static int n, k;
    static Set<String> check;
    static int bitmask, selected;
    static Set<Integer> li = new HashSet<>();
    static int cnt, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) - 5;
        check = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String ss = s.substring(4, s.length() - 4);
            check.add(ss);
            for (int j = 0; j < ss.length(); j++) {
                char c = ss.charAt(j);
                bitmask = bitmask | (1 << ((int) c - 97)); // 알파벳 있는거 표시
            }
        }
        if (k < 0) {
            System.out.println(0);
        } else {
            selected |= 1 << 'a' - 'a';
            selected |= 1 << 'n' - 'a';
            selected |= 1 << 't' - 'a';
            selected |= 1 << 'i' - 'a';
            selected |= 1 << 'c' - 'a';
            li.add(selected);
            comb(0, 0);
            for (int now : li) {
                cnt = 0;
                for (String s : check) {
                    int l = s.length();
                    boolean canRead = true;
                    for (int j = 0; j < l; j++) {
                        char c = s.charAt(j);
                        if ((now & 1 << ((int) c - 97)) != 0) {
                            continue;
                        }
                        canRead = false;
                        break;
                    }

                    if (canRead) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
            System.out.println(ans);
        }
    }

    public static void comb(int depth, int cnt) {
        if (cnt == k) {
            li.add(selected);
            return;
        }
        if (depth == 26) {
            return;
        }

        if ((bitmask & 1 << depth) != 0/* && (selected & 1 << depth) == 0*/) {
            selected |= 1 << depth;
            comb(depth + 1, cnt + 1);
            selected &= ~(1 << depth);
        }
        comb(depth + 1, cnt);
    }
}
