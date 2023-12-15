package 코드트리.자료구조_중급.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 차이가_가장_작은_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> dist = new TreeSet<>();
        // 차이가 가장 작은 수는 무엇인가?
        // n개의 수열 중에서 두 개를 고른다.
        // -> 완탐 : 불가능, 조합 : 할줄모름, 하나(a)를 고르고 나머지를 도출 O
        // 차이가 m 이상이면서 제일 작은 경우 -> 트리셋에서 .floor(a-m)랑 .ceiling(m+a) 찾음(b)
        // -> dist.add(Math.abs(b-a))
        // print(dist.first())
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }
        for (Integer a : set) {
            Integer v1 = set.floor(a - m) != null ? set.floor(a - m) : Integer.MAX_VALUE;
            Integer v2 = set.ceiling(m + a) != null ? set.ceiling(m + a) : Integer.MAX_VALUE;
            dist.add(Math.abs(a - v1));
            dist.add(Math.abs(v2 - a));
        }
        if (dist.first() > set.last()) {
            System.out.println(-1);
        } else {
            System.out.println(dist.first());
        }

    }
}
