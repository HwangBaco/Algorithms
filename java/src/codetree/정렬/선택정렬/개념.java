package 코드트리.정렬.선택정렬;

public class 개념 {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < arr.length; i++) {
            int minVal = Integer.MAX_VALUE;
            int minIdx = 0;
            for (int j = i; j < arr.length; j++) {
                if (minVal > arr[j]) {
                    minVal = arr[j];
                    minIdx = j;
                }
            }
            arr[minIdx] = arr[i];
            arr[i] = minVal;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
