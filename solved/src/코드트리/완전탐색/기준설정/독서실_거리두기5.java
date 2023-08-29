package 코드트리.완전탐색.기준설정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 독서실_거리두기5 {
    private static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cnt = 0;
        String ss = "";
        for (int i = 0; i < n; i++) { // cases
            if (i+2 < n && s.substring(i, i + 1).equals("0")) {
                ss = new StringBuffer(s.substring(0, i)).append("1").append(s.substring(i + 2)).toString();
                for (int j = 0; j < n; j++) { // iteration
                    if (j + 1 < n) {
                        String _s = ss.substring(j, j + 1);
                        if (_s.equals("1")) {
                            cnt = 0;
                        } else {
                            cnt++;
                            ans = Math.min(ans, cnt);
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
