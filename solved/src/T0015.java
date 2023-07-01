import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T0015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        int cnt = 0;
        int sum = 0;
        char norm = br.readLine().charAt(0);
        for (String elem :
                arr) {
            if (elem.charAt(0) == norm) {
                sum += elem.length();
                cnt++;
            }
        }
        double ans = (double) sum / (double) cnt;
        System.out.printf("%d %.2f", cnt, ans);
    }
}
