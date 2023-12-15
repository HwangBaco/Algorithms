package 코드트리.진단테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class test6_failed {
    public static int n, k;
    public static TreeSet<Integer> ts = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n-k; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (j >= i && j < i + k) {
                    continue;
                } else {
                    sum += arr[j];
                }
            }
            ts.add(sum);
        }
        ts.add(0);
        System.out.println(ts.last());
    }

    public static boolean inRange(int num) {
        return num >= 0 && num < n;
    }
}
