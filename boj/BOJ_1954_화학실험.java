package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1954_화학실험 {
    private static int n, m;
    private static int ans;
    private static List<int[]> abs;
    private static List<Integer> li;
    private static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        abs = new ArrayList<>();
        li = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            abs.add(new int[]{a, b});
        }

        m = Integer.parseInt(br.readLine());
        comb(0);

        System.out.println(ans);
    }

    private static void comb(int sum) {
        if (li.size() == n) {
            if (sum != m) {
                return;
            }
            int res = abs.get(0)[0] * li.get(0) + abs.get(0)[1];
            for (int i = 1; i < n; i++) {
                Integer x = li.get(i);
                int[] ab = abs.get(i);
                int a = ab[0];
                int b = ab[1];
                if (res != a * x + b) {
                    return;
                }
            }
            ans = res;
            return;
        }

        for (int i = 1; i <= m; i++) {
            li.add(i);
            sum += i;
            comb(sum);
            li.remove(li.size() - 1);
            sum -= i;
        }
    }
}