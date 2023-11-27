package 코드트리.완전탐색.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class 최단_run_length_인코딩_실력검증 {
    private static int n;
    private static Queue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        n = s.length();

        // 주어진 문자열을 shift하고, encoding한다.
        for (int i = 0; i < n; i++) {
            String temp = s.substring(0, 1);
            String left = s.substring(1, n);
            StringBuilder sb = new StringBuilder();
            s = sb.append(left).append(temp).toString();
            encoding(s);
        }
        // 정답을 추출한다.
        System.out.println(pq.poll());
    }

    private static void encoding(String s) {
        // 첫 항을 StringBuilder에 담아둔다.
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        // 중복되는 문자의 길이를 담아줄 duplicateLength 변수를 1로 초기화한다.
        int duplicateLength = 1;

        // 문자열의 index를 1부터 n까지 순회하면서 이전 인덱스의 문자과 현재 인덱스의 문자가 동일한지 비교한다.
        for (int i = 1; i < n; i++) {
            char prevChar = s.charAt(i-1);
            char crtChar = s.charAt(i);

            // 만약 현재 문자가 이전 문자와 중복되는 경우 중복길이 변수에 +1 처리를 한다.
            if (prevChar == crtChar) {
                duplicateLength++;

            // 만약 현재 문자가 이전 문자와 다른 경우, 중복이 종료되었으므로 중복되었던 문자와 그 길이를 인코딩 문자열에 추가하고,
            // 중복 문자열 변수를 1로 초기화한다.
            } else {
                sb.append(duplicateLength);
                sb.append(crtChar);
                duplicateLength = 1;
            }
        }
        // 가장 마지막 문자에 대한 길이 추가를 처리해준다.
        sb.append(duplicateLength);
        // 우선순위 큐에 이번 인코딩 문자열의 길이를 추가해준다.
        pq.add(sb.toString().length());
    }

}
