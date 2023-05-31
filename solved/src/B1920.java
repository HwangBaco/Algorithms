import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920 {
    static int n, m;
    static int[] arr;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid_idx = (start + end)/2;
                int mid_val = arr[mid_idx];
                if (mid_val > target) {
                    end = mid_idx - 1;
                } else if (mid_val < target) {
                    start = mid_idx + 1;
                } else {
                    find = true;
                    break;
                }

            }
            if (find) {
//                bw.write(Integer.toString(1));
                System.out.println(1);
            } else {
//                bw.write(Integer.toString(0));
                System.out.println(0);
            }
//            bw.flush();
            br.close();
//            bw.close();
        }

    }
}
