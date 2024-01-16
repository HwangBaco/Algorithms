package 코드트리.자료구조_중급.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 두_수의_합 {
    public static int n, k, ans;
    public static final int MAX_N = 100000;
    public static long[] arr = new long[MAX_N];
    public static Map<Long, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
        for (int i = 0; i < n; i++) {
            long diff = k - arr[i];
            if (map.containsKey(diff)) {
                ans += map.get(diff);
            }
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        System.out.println(ans);
    }
}
