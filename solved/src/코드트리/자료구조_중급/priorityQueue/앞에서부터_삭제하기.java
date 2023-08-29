package 코드트리.자료구조_중급.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 앞에서부터_삭제하기 {
    private static int n;
    public static void main(String[] args) throws IOException {
        /*
        1번의 루프로,

        주어진 n개의 정수를 우선 배열로 받은 뒤, 역순으로 우선순위 큐와 리스트에 넣고,
        우선순위 큐의 poll() 내용을 리스트에서 제거하고
        list의 평균값을 계속 Double TreeSet에 넣어서 last() 출력
        **/
        Queue<Integer> queue = new PriorityQueue<>();
        TreeSet<Double> set = new TreeSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < n-1; i++) {
            int num = arr[i];
            sum += num;
            queue.add(num);
            if (i < 1) {
                continue;
            }
            Integer poll = queue.poll();
            avg = (double) (sum - poll) / (double) (queue.size());
            set.add(avg);
            queue.add(poll);
        }
        System.out.printf("%.2f", set.last());
    }
}
