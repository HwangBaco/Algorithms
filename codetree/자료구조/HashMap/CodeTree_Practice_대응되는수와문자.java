package 알고리즘연습.codetree.자료구조.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CodeTree_Practice_대응되는수와문자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, String> stoiMap = new HashMap<>();
        Map<String, String> itosMap = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            stoiMap.put(s, String.valueOf(i));
            itosMap.put(String.valueOf(i), s);
        }
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            boolean isNumber = s.chars().allMatch(Character::isDigit); // 입력 문자열이 숫자인지 문자인지 검사
            if (isNumber) {
                sb.append(itosMap.get(s));
            } else {
                sb.append(stoiMap.get(s));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
