package 코드트리.완전탐색.물체탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 스승의_은혜3 {
    private static int[][] arr;
    private static final int PRICE_IDX = 0;
    private static final int DELIVERY_IDX = 1;
    private static final int ARR_SIZE = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int ans = Integer.MIN_VALUE;
        arr = new int[n][ARR_SIZE];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        // 학생의 순서가 중요한 건 아니니까 오름차순 정렬하고 접근
        // 최대한 많은 명수를 확보해야 하므로 낮은 가격부터 카운트
        for (int i = 0; i < n; i++) { // 할인하는 학생 선택
            int balance = b;
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
//                    if (o1[0] == o2[0]) {
//                        return o1[1] - o2[1];
//                    }
                    return (o1[0] + o1[1]) - (o2[0] + o2[1]);
                }
            });
            arr[i][PRICE_IDX] /= 2;
            int res = 0;
            for (int j = 0; j < n; j++) { // 전체 순회
                if (balance - arr[j][PRICE_IDX] - arr[j][DELIVERY_IDX] >= 0) {
                    balance = balance - arr[j][PRICE_IDX] - arr[j][DELIVERY_IDX];
//                    System.out.println("arr[j][PRICE_IDX] = " + arr[j][PRICE_IDX]);
//                    System.out.println("arr[j][DELIVERY_IDX] = " + arr[j][DELIVERY_IDX]);
//                    System.out.println("balance = " + balance);
                    res++;
//                    System.out.println("res = " + res);
                }
                ans = Math.max(ans, res);
            }
            arr[i][PRICE_IDX] *= 2;
        }
        System.out.println(ans);
    }
}
