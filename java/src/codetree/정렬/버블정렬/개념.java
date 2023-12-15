package 코드트리.정렬.버블정렬;

import java.util.Arrays;

public class 개념 {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        boolean isSorted;
        do {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] < arr[i]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    isSorted = false;
                }
            }
        } while (!isSorted);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
