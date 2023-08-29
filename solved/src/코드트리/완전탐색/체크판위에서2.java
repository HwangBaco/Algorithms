package 코드트리.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체크판위에서2 {
    private static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new String[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = st.nextToken();
            }
        }
        String first = "";
        int ans = 0;
        // 점프는 최소 +1+1된 좌표부터 && 색이 다른 칸으로
        // 양 끝의 타일이 같은 경우에는 주제 성립 X
        // 두 개의 칸만 찾으면 됨. 이것만 만족하면 +1;
        if (!arr[0][0].equals(arr[r - 1][c - 1])) {
            for (int i = 1; i < r; i++) {
                for (int j = 1; j < c; j++) {
                    // 첫 번째 점 발견
                    if (!arr[i][j].equals(arr[0][0])) {
                        for (int k = i + 1; k < r-1; k++) {
                            for (int l = j + 1; l < c-1; l++) {
                                // 두 번째 점 발견
                                if (!arr[k][l].equals(arr[r - 1][c - 1])) {
                                    System.out.printf("%d %d %d %d\n", i, j, k, l);
                                    ans++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
