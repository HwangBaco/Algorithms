package 알고리즘연습.codetree.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class CodeTree_알파벳과사칙연산 {
    private static int keySize, ans, n;
    private static String s;
    private static HashMap<Integer, Character> mapper = new HashMap<>();
    private static HashMap<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        ans = Integer.MIN_VALUE;
        s = new BufferedReader(new InputStreamReader(System.in)).readLine();
        n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c - 'a' >= 0) { // a부터 f 사이인 경우
                map.put(c, 0);
            }
        }
        keySize = map.keySet().size();
        int i = 0;
        for (Character c : map.keySet()) {
            mapper.put(i++, c);
        }
        go(0);

        System.out.println(ans);
    }

    private static void go(int depth) {
        if (depth == keySize) {
            int res = map.get(s.charAt(0));
            for (int i = 1; i < n; i++) {
                char operator = s.charAt(i++);
                int operand = map.get(s.charAt(i));
                if (operator == '+') {
                    res += operand;
                } else if (operator == '-') {
                    res -= operand;
                } else if (operator == '*') {
                    res *= operand;
                }
            }
            ans = Math.max(ans, res);
            return;
        }
        for (int i = 1; i <= 4; i++) {
            Character c = mapper.get(depth);
            map.put(c, i);
            go(depth + 1);
        }
    }
}
