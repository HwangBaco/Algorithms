import java.io.*;
import java.util.*;

public class CodeTree_컴퓨터와함께하는숫자게임2 {
    static long M;
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Long.parseLong(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int max = 0;
        int min = (int) 1e9;
        for (long i = a; i <= b; i++) {
            int res = bsCnt(i);
            min = Math.min(min, res);
            max = Math.max(max, res);
        }
        System.out.println(min + " " + max);
    }
    public static int bsCnt(long v) {
        long left = 1;
        long right = M;
        int cnt = 0;
        while (left <= right) {
            cnt++;
            long mid = (left + right) / 2;
            if (mid > v) {
                right = mid - 1;
            } else if (mid < v) {
                left = mid + 1;
            } else {
                break;
            }
        }
        return cnt;
    }
}
