package 코드트리.시간단축기술.전처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 괄호쌍_만들어주기 {
    public static void main(String[] args) throws IOException {
        /*
        * 닫는 괄호가 두 번 연속으로 나오는 모양을 오른쪽부터 세어서 누적합으로 배열에 입력
        **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int n = s.length();
        int[] arr = new int[n];
        for (int i = n-2; i >= 0; i--) {
            if (s.substring(i, i+2).equals("))")) {
                arr[i] += 1 + arr[i+1];
            } else {
                arr[i] += arr[i+1];
            }
        }
        long ans = 0;
        for (int i = 0; i < n-2; i++) {
            if (s.substring(i, i + 2).equals("((")) {
                ans += arr[i];
            }
        }
        System.out.println(ans);
    }
}
