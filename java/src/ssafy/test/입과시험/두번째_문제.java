package ssafy.test.입과시험;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class 두번째_문제 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= t; i++) {
            // init 조건
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Queue<Integer> pq = new PriorityQueue<>();

            // init 리스트
            st = new StringTokenizer(br.readLine());
            List<Integer> li = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                li.add(Integer.parseInt(st.nextToken()));
            }
            li.sort(Comparator.reverseOrder());

            // 케이스 리스트 세팅
            Integer headItem = li.get(0);
            while (li.contains(headItem)) {
                li.remove(0);
            }
            Integer tailItem = li.get(li.size() - 1);
            while (li.contains(tailItem)) {
                li.remove(li.size() - 1);
            }


            // 헤드에서 잘라내는 경우랑
            List<Integer> midRange = new ArrayList<>();
            midRange.addAll(li);

            while (true) {
                if (midRange.size() <= b) {
                    pq.add(-midRange.size());
                    break;
                }
                Integer remove = midRange.remove(0);
                // 중복 제거
                while (midRange.contains(remove)) {
                    midRange.remove(remove);
                }
            }

            // 테일에서 잘라내는 경우를 탐색
            midRange = new ArrayList<>();
            midRange.addAll(li);

            while (true) {
                if (midRange.size() <= b) {
                    pq.add(-midRange.size());
                    break;
                }
                Integer remove = midRange.remove(midRange.size() - 1);
                while (midRange.contains(remove)) {
                    midRange.remove(remove);
                }
            }

            // 둘 중에서 더 큰 케이스로 낙찰
            StringBuilder sb = new StringBuilder("");
            sb.append("#");
            sb.append(i);
            sb.append(" ");
            sb.append(-pq.poll());
            System.out.println(sb.toString());

        }
    }
}
