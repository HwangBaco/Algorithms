package 알고리즘연습.programmers;

public class PGS_입국심사 {
    static int[] arr;

    public long solution(int n, int[] times) {
        arr = times;
        long answer = bs(n);

        return answer;
    }

    private long bs(int v) {
        long left = 1;
        long right = (long) 1e15;
        long res = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (foo(mid) >= v) {
                right = mid - 1;
                res = Math.min(res, mid);
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private long foo(long v) {
        long res = 0;
        for (int i : arr) {
            res += (long) v / i;
        }
        return res;
    }
}
