package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2042_구간합구하기 {
    /*
    * 세그먼트 트리 연습문제
    * */
    private static long[] tree; // 트리 배치
    private static long[] arr; // 문자 배치

    // 구간합 세그먼트 트리 초기화
    private static long init(int node, int start, int end) {
        if (start == end) { // leaf node인 경우
            return tree[node] = arr[start];
        }

        int mid = (start + end) >> 1;
        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    private static long sum(int node, int start, int end, int left, int right) {
        // 범위를 아예 벗어난 경우에는 0을 더함
        if (left > end || right < start) {
            return 0;
        }

        // 범위 내에 있는 노드에 대하여는 그 값을 반환
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) >> 1;
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
    }

    private static void update(int node, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) {
            return;
        }

        tree[node] += diff;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(node * 2, start, mid, idx, diff);
        update(node * 2 + 1, mid + 1, end, idx, diff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // update 횟수
        int k = Integer.parseInt(st.nextToken()); // 구간합 횟수

        arr = new long[n+1];
        int h = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1);
        tree = new long[treeSize];
//        tree = new long[n << 2];


        for (int i = 1; i <= n; i++) {
            long num = Long.parseLong(br.readLine().trim());
            arr[i] = num;
        }
        init(1, 1, n);

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // update
                long diff = c - arr[b];
                arr[b] = c;
                update(1, 1, n, b, diff);
            } else { // sum
                long res = sum(1, 1, n, b, (int) c);
                sb.append(res).append("\n");
            }
        }
        System.out.println(sb);
    }
}
