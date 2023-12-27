package ssafy.test.입과시험;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class 첫번째_문제
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken()); // test case 개수

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 숫자 개수
            List<Integer> li = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                li.add(Integer.parseInt(st.nextToken()));
            }
            // 정렬
            li.sort(Comparator.naturalOrder());

            int priceSum = 0;
            while (!li.isEmpty()) {
                // 뒤에서부터 하나씩 일단 뽑아
                Integer mostExpensiveItem = li.get(li.size() - 1);
                li.remove(mostExpensiveItem);
                priceSum += mostExpensiveItem;

                // 뽑고나서 맨 뒤에꺼 한번 더 봐
                int idx = li.size() - 1;
                while(!li.isEmpty()) {
                    if (idx >= 0 && li.get(idx) < mostExpensiveItem) {
                        li.remove(idx); // 공짜 처리
                        break;
                    }
                    idx--;
                    // 공짜로 줄 게 없는 경우 : pass
                    if (idx < 0) {
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder("");
            sb.append("#");
            sb.append(i);
            sb.append(" ");
            sb.append(priceSum);
            System.out.println(sb.toString());
        }

    }
}
