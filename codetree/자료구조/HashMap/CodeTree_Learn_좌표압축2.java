package 알고리즘연습.codetree.자료구조.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 코드트리 - 가장 많은 데이터
 */
public class CodeTree_Learn_좌표압축2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int max = -1;
        String maxKey = null;
        for (int i = 0; i < n; i++) {
            String key = br.readLine();
            int value = map.getOrDefault(key, 0) + 1;
            map.put(key, value);
            if (max < value) {
                max = value;
                maxKey = key;
            }
        }
        System.out.println(map.get(maxKey));
    }
}
