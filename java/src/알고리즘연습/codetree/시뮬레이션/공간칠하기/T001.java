package 코드트리.시뮬레이션.공간칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] arr = new int[201][201];

        int n = Integer.parseInt(st.nextToken());
        int x, y;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // 가로세로 8씩, 넓이가 64
            x = Integer.parseInt(st.nextToken()) + 100;
            y = Integer.parseInt(st.nextToken()) + 100;
            for (int j = x; j < x+8; j++) {
                for (int k = y; k < y+8; k++) {
                    arr[j][k] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (arr[i][j] == 1) ans++;
            }
        }
        System.out.println(ans);
    }
}
