package 코드트리.시간단축기술.쁠마원테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 서로_다른_구간의_수 {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
        * 수직선 상의 n개의 구간
        * 구분되는 구간의 개수를 출력
        *
        * 주어지는 모든 좌표값은 다르다고 가정
        *
        * 트리맵을 이용하여 x, +1 // y,-1로 하면 됨
        **/
        TreeMap<Integer, Integer> map = new TreeMap<>();
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(x, 1);
            map.put(y, -1);
        }
        int ans = 0;
        int cnt = 0;
        for (Integer key : map.keySet()) {
            if (cnt == 0 && map.get(key) == 1) {
                ans++;
            }
            cnt += map.get(key);
        }
        System.out.println(ans);

    }
}
