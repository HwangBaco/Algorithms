package 알고리즘연습.codetree.자료구조.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * 코드트리 - 숫자 등장 횟수
 */
public class CodeTree_Learn_좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String key = st.nextToken();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(map.getOrDefault(st.nextToken(), 0)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
