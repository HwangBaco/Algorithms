package 코드트리.시뮬레이션.dxdy테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가운데에서_시작하여_빙빙_돌기 {
    public static int n;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        List<Integer> dist = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++) {
            dist.add(i);
            dist.add(i);
        }
        // starting point
        int x = n/2;
        int y = n/2;

        // init array
        arr = new int[n][n];
        int idx = 0;
        int cnt = 1;
        int ascii = 97;
        // parade
        while (true) {
            if (!inRange(x, y)) {
                break;
            }
            for (int i = 0; i < dist.get(idx); i++) {
//                arr[y][x] = cnt++;
                arr[y][x] = ascii++;
                y = y + dy[idx % 4];
                x = x + dx[idx % 4];
            }
            idx++;
        }
        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((char) arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
}
