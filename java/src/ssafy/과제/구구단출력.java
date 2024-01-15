package ssafy.과제;

import java.io.IOException;
import java.util.Scanner;

public class 구구단출력 {
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("숫자를 입력하세요 : ");
//        while (true) {
//            int n = sc.nextInt();
//            if (n == 0) {
//                break;
//            }
//            for (int i = 1; i <= 9; i++) {
//                System.out.println(n + " * " + i + " = " + n * i);
//            }
//            System.out.print("다음 숫자 입력 : ");
//        }
//        System.out.println("프로그램 종료");
//    }
public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("숫자를 입력하세요 : ");
    int num = sc.nextInt();
    // 입력한 숫자 검사
    // 0을 입력받으면 반복 종료
    while (true) {
        // 1부터 9까지 곱해서 출력
        for (int i = 1; i <= 9; i++) {
            System.out.println(num + " * " + i + " = " + num * i);
        }
        System.out.print("다음 숫자 입력 : ");
        num = sc.nextInt();
        if (num == 0) {
            break;
        }
    }

    System.out.println("프로그램 종료");

}
}
