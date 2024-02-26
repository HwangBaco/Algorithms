package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2457_공주님의정원 {
    // 그리디
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Date[] arr = new Date[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            arr[i] = new Date(sm, sd, em, ed);
        }

        // 시작일 기준으로 정렬
        Arrays.sort(arr, ((o1, o2) -> {
            if (o1.startMonth == o2.startMonth) { // 시작 날짜 오름차순
                return o1.startDay - o2.startDay;
            }
            return o1.startMonth - o2.startMonth;
        }));

        PriorityQueue<Date> pq = new PriorityQueue<>((o1, o2) -> { // 끝나는 날짜 내림차순
            if (o1.endMonth == o2.endMonth) {
                return o2.endDay - o1.endDay;
            }
            return o2.endMonth - o1.endMonth;
        });

        int stdMonth = 3;
        int stdDay = 1;
        int cnt = 0;
        // 가능한 날짜들을 전부 pq에 담고
        for (Date d : arr) {
            if (stdMonth > 11 || stdMonth == 11 && stdDay >= 31) {
                System.out.println(cnt);
                return;
            }
            int sm = d.startMonth;
            int sd = d.startDay;
            int em = d.endMonth;
            int ed = d.endDay;
            if (!(stdMonth > sm || (stdMonth == sm && (stdDay) >= sd))) { // 기준일을 넘어서 선택해야 하는 경우
                if (pq.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                Date poll = pq.poll();
                stdMonth = poll.endMonth;
                stdDay = poll.endDay;

                cnt++;
//                System.out.println(stdMonth + " " + stdDay);

                pq = new PriorityQueue<>((o1, o2) -> { // 끝나는 날짜 내림차순
                    if (o1.endMonth == o2.endMonth) {
                        return o2.endDay - o1.endDay;
                    }
                    return o2.endMonth - o1.endMonth;
                });
            }

            if ((stdMonth > sm || (stdMonth == sm && (stdDay) >= sd))) {
                // 아직 기준일에 미치지 않는 경우 == 가능한 경우
                pq.add(d); // 우선순위 큐에 담아둠

            } else {
                System.out.println(0);
                return;
            }

        }
        if (stdMonth > 11 || stdMonth == 11 && stdDay >= 31) {
            System.out.println(cnt);
            return;
        }
        if (!pq.isEmpty()) {
            Date poll = pq.poll();
            stdMonth = poll.endMonth;
            stdDay = poll.endDay;
        }

        cnt++;
        if (!(stdMonth > 11 || stdMonth == 11 && stdDay >= 31)) {
            System.out.println(0);
            return;
        }
        System.out.println(cnt);
    }

    private static class Date {
        int startMonth, startDay, endMonth, endDay;
        private Date(int sm, int sd, int em, int ed) {
            startMonth = sm;
            startDay = sd;
            endMonth = em;
            endDay = ed;
        }
    }
}
