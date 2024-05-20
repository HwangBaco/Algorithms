import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static int len;
    private static int ans = (int) 1e9;
    private static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        len = s.length();
        N = Integer.parseInt(s); // target channel
        M = Integer.parseInt(br.readLine()); // broken buttons count
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
        }
        ans = Math.abs(N - 100);
        for (int i = 1; i <= len + 1; i++) {
            go(0, new int[len + 1], i);
        }
        System.out.println(ans);
    }

    public static void go(int depth, int[] nums, int length) {
        if (depth == length) {
            int res = 0;
            int cnt = length;
            boolean keepZero = true;
            for (int i = length - 1; i >= 0; i--) {
                if (keepZero && i > 0 && nums[i] == 0) {
                    cnt--;
                } else if (nums[i] != 0) {
                    keepZero = false;
                }
                res += nums[i] * ((int) Math.pow(10, i));
            }
            ans = Math.min(ans, cnt + Math.abs(N - res));
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (set.contains(i)) {
                continue;
            }
            nums[depth] = i;
            go(depth+1, nums, length);
        }
    }
}