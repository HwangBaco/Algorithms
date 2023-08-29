package 코드트리.이진탐색.parametric_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 자연수_n개의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mid = n / 2;
        boolean isfound = false;
        while (true) {
            if (getSum(mid) <= n) {
                mid = mid + 1;
                isfound = true;

            } else if (isfound == true) {
                mid = mid - 1;
                if (getSum(mid) == n) {
                    break;
                }
            } else {
                mid = mid - 1;
            }
        }
        System.out.println(mid);
    }

    public static int getSum(int n) {
        return (n + n + 1) / 2;
    }
}
