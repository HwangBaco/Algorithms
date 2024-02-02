package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class BOJ_2164_카드2 {
    public static void main(String[] args) throws IOException {
        /*
        * 카드 N장 (1 ~ 5 * 1e5)
        *
        * 첫째 줄에 남는 카드 번호 출력
        *
        * 처음에 오름차순으로 정렬되어있음
        *
        * 제일 위 카드를 바닥에 버림
        * 그리고 제일 위에 있는 카드를 아래로 옮김
        *
        * 하나 남았을 때 카드 출력
        * */
        Deque<Integer> dq = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        IntStream.rangeClosed(1, n).forEach(dq::add);

        while (dq.size() != 1) {
            dq.pollFirst();
            Integer i = dq.pollFirst();
            dq.add(i);
        }
        System.out.println(dq.poll());
    }
}
