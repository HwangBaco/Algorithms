package ssafy.과제;

import java.util.Scanner;

public class 일차월배열_순회_짝수_출력 {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        printNumbers(arr);
        printEvenNumbers(arr);
        setNumber(arr);
        printNumbers(arr);
    }

    private static void setNumber(int[] arr) {
        Scanner sc = new Scanner(System.in);
        System.out.print("-----바꿀 위치 입력 : ");
        int idx = sc.nextInt();
        System.out.print("-----수 입력 : ");
        int num = sc.nextInt();
        if (idx >= 0 && idx < arr.length) {
            arr[idx] = num;
        }
    }

    private static void printNumbers(int[] arr) {
        System.out.println("-----원소 10개 출력-----");
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    private static void printEvenNumbers(int[] arr) {
        System.out.println("-----원소 10개 중 짝수만 출력-----");
        for (int elem : arr) {
            if (elem % 2 == 0) {
                System.out.print(elem + " ");
            }
        }
        System.out.println();
    }
}
