package 코드트리.시뮬레이션.공간칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T004 {
    public static final int OFFSET = 100;
    public static final int SIZE = 200;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[][] arr = new String[SIZE+1][SIZE+1];
        int n = Integer.parseInt(st.nextToken());
        int x1, x2, y1, y2;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken()) + OFFSET;
            y1 = Integer.parseInt(st.nextToken()) + OFFSET;
            x2 = Integer.parseInt(st.nextToken()) + OFFSET;
            y2 = Integer.parseInt(st.nextToken()) + OFFSET;
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    if (i % 2 == 0) {
                        arr[j][k] = "r";
                    } else {
                        arr[j][k] = "b";
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (arr[i][j] != null && arr[i][j].equals("b")) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

}
