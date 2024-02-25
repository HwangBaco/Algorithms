package 알고리즘연습.codetree.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* @author HwangBaco
* @algorithm parametric search (solve problems using binary search)
* @time O(logS)
*
* 1부터 n까지의 자연수의 합이 100이상인 경우 중
* 가능한 n의 최솟값을 구하는 프로그램
*
* 단, 답은 1에서 30 사이
*
* */
public class CodeTree_자연수n개의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());

        long left = 1;
        long right = s;
        long maxNum = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (sigma(mid) <= s) {
                left = mid + 1;
            } else {
                right = mid - 1;
                maxNum = Math.max(maxNum, mid);
            }
        }
        System.out.println(maxNum);
    }

    private static long sigma(long num) {
        return (num * (num + 1)) / 2;
    }
}
