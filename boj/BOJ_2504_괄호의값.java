package 알고리즘연습.boj;

import java.io.*;
import java.util.*;

public class BOJ_2504_괄호의값 {
    private static int ans = 0;
    private static Deque<String> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        int l = s.length();

        int res = 1;
        for (int i = 0; i < l; i++) {
            String ss = s.substring(i, i + 1);

            if (ss.equals("(")) {
                res *= 2;
                stack.add("(");
            } else if (ss.equals("[")) {
                res *= 3;
                stack.add("[");
            } else if (ss.equals(")")) {
                if (stack.size() == 0) {
                    ans = 0;
                    break;
                }
                String peek = stack.pollLast();
                if (!peek.equals("(")) {
                    ans = 0;
                    break;
                }
                ans += s.substring(i-1,i).equals("(") ? res : 0;
                res /= 2;

            } else { // ss.equals("]")
                if (stack.size() == 0) {
                    ans = 0;
                    break;
                }
                String peek = stack.pollLast();
                if (!peek.equals("[")) {
                    ans = 0;
                    break;
                }
                ans += s.substring(i-1,i).equals("[") ? res : 0;
                res /= 3;
            }
        }
        if (stack.size() > 0) {
            System.out.println(0);
            return;
        }

        br.close();
        bw.write(sb.append(ans).toString());
        bw.flush();
        bw.close();
    }
}
