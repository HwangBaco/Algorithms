import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{a, b};
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int[] lis = new int[N];
        int[] rec = new int[N];

        Arrays.fill(lis, (int) 1e9);

        lis[0] = arr[0][1];
        rec[0] = 0;
        int idx = 0;

        for (int i = 1; i < N; i++) {
            if (arr[i][1] > lis[idx]) {
                lis[++idx] = arr[i][1];
                rec[i] = idx;
            } else {
                int jdx = Arrays.binarySearch(lis, arr[i][1]);
                if (jdx < 0) {
                    jdx = Math.abs(jdx) - 1;
                }
                lis[jdx] = arr[i][1];
                rec[i] = jdx;
            }
        }
        int res = idx + 1;
        System.out.println(N - res);

        HashSet<Integer> set = new HashSet<>();
        for (int i = N - 1; i >= 0; i--) {
            if (rec[i] == idx) {
                set.add(arr[i][0]);
                idx--;
            }
        }
        for (int i = 0; i < N; i++) {
            if (!set.contains(arr[i][0])) {
                System.out.println(arr[i][0]);
            }
        }

    }
}