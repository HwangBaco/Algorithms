package 코드트리.시간단축기술.좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 점_개수_세기3 {
    private static int n, q;
    public static void main(String[] args) throws IOException {
        /*
         * n과 q가 주어지고,
         * 수직선 상 n개의 위치가 주어짐
         * q개의 구간이 주어짐
         *
         * 주어지는 점의 위치의 범위가 10의 9승 정도이기 때문에,
         * 원래 누적합을 할거면 10의 9승 정도의 배열을 선언해야 한다.
         *
         * 주어지는 점을 우선 트리셋에 넣고, 트리셋에서 first()를 계속 뽑으며
         * map에 1,2,3... 으로 넣어준다.
         *
         **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < n; i++) {
            map.put(set.pollFirst(), i + 1);
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(map.get(b) - map.get(a) + 1);
        }

    }
}
