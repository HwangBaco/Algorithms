package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T0030 {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        printNum(n-1);

    }

    private static void printNum(int idx) {
        if (idx < 0) return;

        System.out.print(arr[idx] + " ");
        printNum(idx-1);
        System.out.print(arr[idx] + " ");
    }
}
