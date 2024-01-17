package 코드트리.완전탐색.백트래킹;

import java.io.*;
import java.util.*;

public class 일차원_윷놀이 {
    /*
    * 고르는 조합의 풀은 k까지
    * 재귀의 깊이는 n
    * 턴에 주어지는 숫자는 queue에 넣고 (FIFO)
    * 재귀 라운드마다 골라지는 말에 더함 (말은 dictionary)
    * 재귀를 다 돌면 map을 순회하면서 점수 계산
    * 얻는 점수는 PQ에 담고, 이후 -pq.poll()로 최대값 찾기
    * */
    private static int n, m, k;
    private static List<Integer> q = new ArrayList<>();
    private static Queue<Integer> pq = new PriorityQueue<>();
    private static List<Integer> li = new ArrayList<>();
    private static Map<Integer, Integer> map = new HashMap<>();

    private static void go() {
        if (li.size() == n) {
            for (int i = 0; i < k; i++) {
                map.put(i, 1); // init
            }
            for (int i = 0; i < n; i++) {
                int step = q.get(i);
                Integer key = li.get(i);
                map.put(key, map.get(key) + step);
            }
            int ans = 0;
            for (int i = 0; i < k; i++) {
                int t = map.get(i);
                if (t >= m) {
                    ans++;
                }
            }
            pq.add(-ans);
            return;
        }
        for (int i = 0; i < k; i++) {
            li.add(i);
            go();
            li.remove(li.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            q.add(temp);
        }
        go();
        System.out.println(-pq.poll());
    }
}
