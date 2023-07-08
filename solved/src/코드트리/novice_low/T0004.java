package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T0004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 원소의 개수
        int q = Integer.parseInt(st.nextToken()); // 쿼리 개수
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a, b;
            if (command == 1) {
                // 원소 출력
                a = Integer.parseInt(st.nextToken());
                System.out.println(arr[a-1]);
            } else if (command == 2) {
                // 원소 있는지 조회, 있으면 '몇 번째' 원소인지 출력, 중복되면 낮은 index 출력, 없으면 0
                a = Integer.parseInt(st.nextToken());
                boolean flag = false;
                for (int j = 0; j < n; j++) {
                    if (arr[j] == a) {
                        System.out.println(j + 1);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println(0);
                }

            } else {
                // a번째 원소부터 b번째 원소까지 순서대로 공백 출력
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                for (int j = a-1; j < b; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }
        }
    }
}
