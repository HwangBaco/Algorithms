package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_나무높이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            LinkedList<Integer> li = new LinkedList<>();

            int max = -1;
            int min = (int) 1e9;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
                min = Math.min(min, num);
                li.add(num);
            }

            if (max == min) {
                System.out.printf("#%d %d\n", t, 0);
                continue;
            }

            int i = li.indexOf(max);
            Integer maxHeight = li.get(i);

            List<Integer> arr = new ArrayList<>();
            for (Integer integer : li) {
                if (integer == maxHeight) {
                    continue;
                }
                arr.add(maxHeight - integer);
            }

            int ans = 0;
            int oneCnt = 0;
            int twoCnt = 0;
            for (Integer h : arr) {
//                System.out.println(h);
                ans += (h / 3) * 2;
//                System.out.println(ans);
                int mod = h % 3;
                if (mod == 1) {
                    oneCnt++;
                } else if (mod == 2) {
                    twoCnt++;
                }
            }
//            System.out.println(oneCnt + " " + twoCnt);
            if (oneCnt > 0 && twoCnt == 0) {
                ans += oneCnt * 2 - 1;
            } else if (twoCnt > 0 && oneCnt == 0) {
                int res = twoCnt / 3;
                int mod = twoCnt % 3;
                if (mod > 0) {
                    mod++;
                }
                ans += res * 4 + mod;
            } else if (oneCnt > 0 && twoCnt > 0) {
                if (oneCnt >= twoCnt) {
                    ans += twoCnt * 2;
                    ans += (oneCnt - twoCnt) * 2 - 1;
                } else {
                    ans += oneCnt * 2;
                    int diff = twoCnt - oneCnt;
                    int res = diff / 3;
                    int mod = diff % 3;
                    if (mod > 0) {
                        mod++;
                    }
                    ans += res * 4 + mod;
                }
            }

            System.out.printf("#%d %d\n", t, ans);

        }
    }
}
