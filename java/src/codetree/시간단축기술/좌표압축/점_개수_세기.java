package 코드트리.시간단축기술.좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 점_개수_세기 {
    private static int n, q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> mapper = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            set.add(temp);
            set2.add(temp);
        }
        for (int i = 0; i < n; i++) {
            mapper.put(set.pollFirst(), i + 1);
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int _a = 0, _b = 0;
            boolean isValid = true;
            if (set2.ceiling(a) != null) {
                _a = set2.ceiling(a);
            } else {
                isValid = false;
            }
            if (set2.floor(b) != null) {
                _b = set2.floor(b);
            } else {
                isValid = false;
            }
            if (isValid == true) {
                System.out.println(mapper.get(_b) - mapper.get(_a) + 1);
            } else {
                System.out.println(0);
            }
        }
    }
}
