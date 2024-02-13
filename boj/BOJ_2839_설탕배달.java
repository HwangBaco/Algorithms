package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕배달 {
    /*
    * 실행 시간 : 124 ms
    *
    * 메모리 : 14172 KB
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 5 만으로 정답이 가능한 경우
        if (n % 5 == 0) {
            System.out.println(n / 5);

        // 3 을 같이 사용해야 하는 경우
        } else {
            int ans = 0;
            while (n > 0) {

                // 3을 하나씩 쓰면서
                n -= 3;
                ans++;

                // 5로 대처 가능한지 체크
                if (n % 5 == 0) {
                    ans += n / 5;
                    System.out.println(ans);
                    return;

                // 불가능하면 -1 출력
                } else if (n == 1 || n == 2) {
                    System.out.println(-1);
                    return;
                }
            }
        }



    }
}
