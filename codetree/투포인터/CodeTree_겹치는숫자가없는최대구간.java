package 알고리즘연습.codetree.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_겹치는숫자가없는최대구간 {
    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] counting = new int[100001];

        int right = 0; // right pointer init
        int ans = 0;
        for (int left = 0; left < N; left++) { // left pointer
            while (right < N) {
                int num = arr[right];
                if (counting[num] == 1) {
                    break;
                }
                counting[num]++;
                right++;
            }
            ans = Math.max(ans, right - left);
            int pop = arr[left];
            counting[pop]--;
        }

        System.out.println(ans);
    }
}
