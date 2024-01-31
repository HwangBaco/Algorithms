package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_지도칠하기 {
    private static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ans = Integer.MAX_VALUE;

            int n = Integer.parseInt(br.readLine());
            int[] origin = new int[n]; // original array

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                origin[i] = num;
            }
            int[] adj = new int[n];
            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < n; x++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        adj[y] = adj[y] | (1 << x);
                    }
                }
            }
            perm(new ArrayList<>(), n, origin, adj);

            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    private static void perm(ArrayList<Integer> li, int n, int[] origin, int[] adj) {
        if (li.size() == n) {
            int res = 0;
            if (noProblem(n, li, origin, adj)) {
                for (int i = 0; i < n; i++) {
                    res += (li.get(i) & origin[i]) == origin[i] ? 0 : 1;
                }
                ans = Math.min(ans, res);
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            li.add(i);
            perm(li, n, origin, adj);
            li.remove(li.size() - 1);
        }
    }


    private static boolean noProblem(int n, ArrayList<Integer> li, int[] origin, int[] adj) {
        for (int i = 0; i < n; i++) {
            int permedColor = li.get(i);
            int adjBit = adj[i];

            for (int j = 0; j < n; j++) {
                if ((adjBit & 1 << j) != 0 && (permedColor ^ origin[j]) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
