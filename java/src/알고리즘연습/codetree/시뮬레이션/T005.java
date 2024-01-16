package 코드트리.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int[] dOfM = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int elapsedDay = 0;
        for (int i = 0; i < m1; i++) {
            elapsedDay += dOfM[i];
        }
        elapsedDay += d1;
        int monday = elapsedDay % 7;
        String[] days = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int elapsedDay2 = 0;
        for (int i = 0; i < m2; i++) {
            elapsedDay2 += dOfM[i];
        }
        elapsedDay2 += d2;

        int res = elapsedDay2 - elapsedDay;
        int ans = (res) / 7;


        st = new StringTokenizer(br.readLine());
        String day = st.nextToken();
        for (int i = 0; i < 7; i++) {
            if (days[i].equals(day)) {
                if (res % 7 >= i) {
                    System.out.println(ans + 1);
                    break;
                } else {
                    System.out.println(ans);
                    break;
                }
            }
        }

    }
}
