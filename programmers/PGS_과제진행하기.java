package 알고리즘연습.programmers;

import java.io.IOException;
import java.util.*;

/**
 * @intuition 새 과제가 오면 stash 해두고 나중에 시간 남을떄마다 꺼내보는 구조이므로 stack 문제겠다.
 * @algorithm stack
 * @time O(N logN) : 배열 정렬 O(N logN) * for loop iteration O(N) * stack 비우기 O(N)
 * @memory O(N) : plans가 2차원 배열이지만 이는 입력배열이라 제외, 그 외 stack 및 answer 는 최악의 경우 O(N)
 */
public class PGS_과제진행하기 {
    public String[] solution(String[][] plans) {
        Deque<Tuple> stack = new ArrayDeque<>();
        int plansLength = plans.length;
        int ansIdx = 0;
        String[] answer = new String[plansLength];

        String prevTask = "";
        String prevStart = "";
        String prevDuration = "";

        Arrays.sort(plans, Comparator.comparingInt(o -> getTime(o[1])));

        for (int i = 0; i < plansLength; i++) {
            String nowTask = plans[i][0];
            String nowStart = plans[i][1];
            String nowDuration = plans[i][2];

            while (i >= 1) {
                if (getEndTime(prevStart, prevDuration) > getTime(nowStart)) {
                    stack.add(new Tuple(prevTask, getDurationLeft(prevStart, prevDuration, nowStart)));
                    break;
                } else {
                    answer[ansIdx++] = prevTask;
                    prevStart = getTimeString(getEndTime(prevStart, prevDuration));
                    if (stack.isEmpty()) {
                        break;
                    }
                    Tuple stash = stack.pollLast();
                    prevTask = stash.task;
                    prevDuration = String.valueOf(stash.duration);
                }
            }

            if (i == plansLength - 1) {
                answer[ansIdx++] = nowTask;
                break;
            }
            prevTask = nowTask;
            prevStart = nowStart;
            prevDuration = nowDuration;
        }

        while(!stack.isEmpty()) {
            answer[ansIdx++] = stack.pollLast().task;
        }

        return answer;
    }
    private int getTime(String timeString) {
        StringTokenizer st = new StringTokenizer(timeString);
        int hour = Integer.parseInt(st.nextToken(":"));
        int min = Integer.parseInt(st.nextToken());
        return hour*100 + min;
    }
    private int getEndTime(String start, String duration) {
        int time = getTime(start);
        int dur = Integer.parseInt(duration);

        int hour = time / 100;
        int min = time % 100;

        int nextHr = (min + dur) / 60;
        int nextMin = (min + dur) % 60;

        hour = hour + nextHr; // 24시간 넘어가도 상관 없음. 그게 더 늦은 시간이 되어야 하니까
        min = nextMin;

        return hour*100 + min;
    }
    private String getTimeString(int time) {
        return String.valueOf(time / 100) + ":" + String.valueOf(time % 100);
    }
    private int getDurationLeft(String prevStart, String prevDuration, String nowStart) {
        // prevStart + prevDuration - nowStart;

        int prevTime = getEndTime(prevStart, prevDuration);
        int nowTime = getTime(nowStart);

        int prevHr = prevTime / 100;
        int prevMin = prevTime % 100;

        int nowHr = nowTime / 100;
        int nowMin = nowTime % 100;

        // 1230 - 1010 = 20분 + 2시간
        // 1210 - 1050 = 2시간 + -40분 = 1시간 20분

        int hrGap = prevHr - nowHr;
        int minGap = prevMin - nowMin;

        if (minGap < 0) {
            hrGap--;
            minGap += 60;
        }

        return hrGap*60 + minGap;
    }
    private class Tuple {
        String task;
        int duration;

        private Tuple(String task, int duration) {
            this.task = task;
            this.duration = duration;
        }
    }
}