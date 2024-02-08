package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11505_구간곱구하기 {
    static long[] tree;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 숫자 입력량
        int m = Integer.parseInt(st.nextToken()); // 업데이트 획수
        int k = Integer.parseInt(st.nextToken()); // 구간 곱 횟수
        arr = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            long num = Long.parseLong(br.readLine());
            arr[i] = num;
        }

        int h = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1);
        tree = new long[treeSize];

        init(1, 1, n);

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1, 1, n, b, diff);
            } else {
                long res = mul(1, 1, n, b, (int) c);
                sb.append(res).append("\n");
            }
        }
        System.out.println(sb);

    }

    public static long init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) >> 1;
        return tree[node] = mod(init(node * 2, start, mid) * init(node * 2 + 1, mid + 1, end));
    }

    public static void update(int node, int start, int end, int idx, long diff) {
        // 범위 초과한 건 할 거 없고
        if (idx < start || idx > end) {
            return;
        }

        // 범위 내 숫자는 업데이트
        tree[node] = mod(tree[node] + diff);

        // 리프 노드면 탐색 종료
        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(node * 2, start, mid, idx, diff);
        update(node * 2 + 1, mid + 1, end, idx, diff);
    }

    public static long mul(int node, int start, int end, int left, int right) {
        // 범위 나가는 곱은 무효 처리
        if (left > end || right < start) {
            return 1;
        }

        // 리프 노드면 숫자 반환
        if (start == end) {
            return tree[node];
        }

        int mid = (start + end) >> 1;
        return mod(mul(node * 2, start, mid, left, right) * mul(node * 2 + 1, mid + 1, end, left, right));
    }

    public static long mod(long v) {
        return v % ((int) 1e9 + 7);
    }
}
