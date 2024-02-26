package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_20361_일우는야바위꾼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 종이컵의 수
        int x = Integer.parseInt(st.nextToken()); // 간식이 들어있는 종이컵이 왼 쪽에서 몇번쨰인지 (간식 종이컵 좌표)
        int k = Integer.parseInt(st.nextToken()); // 컵 위치를 바꾸는 횟수

        HashMap<Integer, Integer> m = new HashMap<>();

        // init map
        for (int i = 1; i <= n; i++) {
            m.put(i, i);
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = m.get(b);
            m.replace(b, m.get(a));
            m.replace(a, temp);
//				System.out.println(m.get(a) + " " + m.get(b));
        }
        int ans = 0;
        for (int key : m.keySet()) {
            if (m.get(key) == x) {
                ans = key;
            }
        }

        System.out.println(ans);
    }
}
