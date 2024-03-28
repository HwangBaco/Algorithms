package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_5397_키로거 {
    private static int N;
    private static StringBuilder sb = new StringBuilder();
    private static Deque<String> left = new ArrayDeque<>();
    private static Deque<String> right = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int length = s.length();
            String ss;
            for (int j = 0; j < length; j++) {
                ss = s.substring(j, j + 1);
                if (ss.equals("<")) {
                    // left pop
                    // right add
                    if (left.isEmpty()) {
                        continue;
                    }
                    String pop = left.pop();
                    right.push(pop);

                } else if (ss.equals(">")) {
                    // right pop
                    // left add
                    if (right.isEmpty()) {
                        continue;
                    }
                    String pop = right.pop();
                    left.push(pop);

                } else if (ss.equals("-")) {
                    // left pop
                    if (left.isEmpty()) {
                        continue;
                    }
                    left.pop();

                } else {
                    left.push(ss);
                }
            }
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
