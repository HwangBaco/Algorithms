package ssafy.과제;

import java.util.Scanner;

public class 몇번째_날인지_구하기 {
    public static void main(String[] args) {
        System.out.println("월과 일을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i < month; i++) {
            cnt += monthToDayConverter(i);
        }
        cnt += day;
        System.out.println(month + "월 " + day + "일은 " + cnt + "번째 날입니다.");
    }

    public static int monthToDayConverter(int month) {
        switch (month) {
            case 2:
                return 28;
            case 1,3,5,7,8,10,12:
                return 31;
            case 4, 6, 9, 11:
                return 30;
            default:
                return -1;
        }
    }
}
