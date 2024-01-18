package 알고리즘연습.kaupc.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1 {
    private static final int SCORE_SIZE = 7;
    private static final int FIRST_RUN = 0;
    private static final int SECOND_RUN = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();
        TreeSet<Integer> set = new TreeSet<>();
        List<Integer> li = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int runScore = 0;
            int trickScore = 0;
            st = new StringTokenizer(br.readLine());
            queue = new PriorityQueue<>();
            li = new ArrayList<>();
            for (int j = 0; j < SCORE_SIZE; j++) {
                int score = Integer.parseInt(st.nextToken());
                if (j < 2) {
                    li.add(score);
                } else {
                    queue.add(-score);
                }
            }
            runScore = Math.max(li.get(FIRST_RUN), li.get(SECOND_RUN));
            trickScore = (-queue.poll());
            trickScore += (-queue.poll());
            set.add(runScore + trickScore);
        }
        System.out.println(set.last());

    }
}

