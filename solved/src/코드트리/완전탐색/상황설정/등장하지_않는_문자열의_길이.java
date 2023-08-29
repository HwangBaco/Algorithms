package 코드트리.완전탐색.상황설정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등장하지_않는_문자열의_길이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = new StringTokenizer(br.readLine()).nextToken();
        for (int i = 1; i <= n; i++) { // 부분문자열 길이
            boolean isPass = false;
            boolean isDone = false;
            int cnt = 0;
            for (int j = 0; j <= n - i; j++) { // 부분문자열 start idx
                // 기준되는 부분문자열 설정
                cnt = 0;
                String std = s.substring(j, j + i);
//                System.out.println("std = " + std);
                for (int k = 0; k <= n - i; k++) { // 슬라이딩 윈도우로 탐색
                    if (std.equals(s.substring(k, k + i))) {
//                        System.out.println("s.substring(k, k + i) = " + s.substring(k, k + i));
                        cnt++;
                        if (cnt >= 2) {
                            isPass = true;
                            break;
                        }
                    }
                }
                if (isPass) {
                    break;
                }
            }
            if (cnt == 1) {
                System.out.println(i);
                break;
            }
        }
    }
}
