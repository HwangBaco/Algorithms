package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1062_가르침 {
    /**
     * memory : 442100KB
     *
     * time : 2892 ms
     *
     * logic : 비트마스킹 이용하여 주어진 문자 저장하고 탐색
     */

    public static int n, k;
    static Set<Integer> masks = new HashSet<>();
    static int mask, selected;
    static int cnt, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) - 5;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String ss = s.substring(4, s.length() - 4);
            int mask = 0;
            for (int j = 0; j < ss.length(); j++) {
                char c = ss.charAt(j);
                mask |= (1 << (c - 97)); // 알파벳 있는거 표시
            }
            masks.add(mask);
        }
        if (k < 0) {
            System.out.println(0);
        } else {
            selected |= 1 << 'a' - 97;
            selected |= 1 << 'n' - 97;
            selected |= 1 << 't' - 97;
            selected |= 1 << 'i' - 97;
            selected |= 1 << 'c' - 97;
            comb(0, 0);
            System.out.println(ans);
        }
    }

    public static void comb(int depth, int cnt) {
        if (cnt == k) {
            int res = 0;
            for (int mask : masks) {
                if ((mask & selected) == mask) {
                    res++;
                }
            }
            ans = Math.max(ans, res);
            return;
        }
        if (depth == 26) {
            return;
        }

//        if ((bitmask & 1 << depth) != 0/* && (selected & 1 << depth) == 0*/) {
            selected |= 1 << depth;
            comb(depth + 1, cnt + 1);
            selected &= ~(1 << depth);
//        }
        comb(depth + 1, cnt);
    }
}
