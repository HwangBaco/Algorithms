import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            int parseInt = Integer.parseInt(s.substring(i, i + 1));
            sum += parseInt;
        }
        System.out.println(sum);
    }
}
