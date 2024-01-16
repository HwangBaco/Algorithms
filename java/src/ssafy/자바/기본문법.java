package ssafy.자바;

import java.util.Scanner;
import java.util.stream.IntStream;

public class 기본문법 {
    public static void main(String[] args) {
//        practice_switch();
        int[] arr = IntStream.range(1, 9).toArray();
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void practice_switch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("score를 입력하세요");
        int score = sc.nextInt();

        if (score < 0 || score > 100) {
            System.out.println("잘못된 입력입니다.");
        } else {
            System.out.println(score + "점은 ");
            switch (score / 10) { // jdk 7부터는 string도 param에 넣을 수 있음 (동등비교로 switch 실행)
                case 10:
                case 9: {
                    System.out.println("A 학점입니다.");
                    break;
                }
                case 8:
                    System.out.println("B 학점입니다.");
                    break;
                case 7:
                    System.out.println("C 학점입니다.");
                    break;
                case 6:
                    System.out.println("D 학점입니다.");
                    break;
                default:
                    System.out.println("F 학점입니다.");
            }

            // jdk 14 버전에 추가
            String 학점 = switch (score / 10) {
                case 10:
                case 9:
                    yield "A";
                case 8:
                    yield "B";
                case 7:
                    yield "C";
                case 6:
                    yield "D";
                default:
                    yield "F";
            };
            System.out.printf("%d점은 %s학점입니다.", score, 학점);

        }
    }
}
