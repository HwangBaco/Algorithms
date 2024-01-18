package kaupc.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem4 {
    static int n, m;
    static int a, b, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < 3; i++) {
            if (i == 0) { // 첫번 째 케이스
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (inRange(j+a, k+b+c)) {
                            int sum = 0;
                            for (int l = 0; l < a; l++) {
                                sum += Arrays.stream(arr).flatMapToInt(e -> Arrays.stream(e)).skip(k).limit(b + c).sum();
                            }
                            queue.add(sum);
                        }
                    }
                }

            } else {
                /*
                두번째 케이스부터는 int[][] sum 배열을 할당해서 저장하는데,
                트럭이랑 자동차를 별개의 loop로 돌면서 값을 계산,
                선언해둔 sum 배열의 각각 인덱스에 저장하여 수행함
                -> 근데 너무 복잡한데?

                **/


            }
        }
    }

    public static boolean inRange(int x, int y) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
