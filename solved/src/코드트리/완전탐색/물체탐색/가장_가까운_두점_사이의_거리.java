package 코드트리.완전탐색.물체탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_가까운_두점_사이의_거리 {
    /*
    주어진 모든 점을 완전 탐색하여 두 점을 선정
    두 점 사이의 거리를 맨해튼 방식으로 구하고
    ans = Math.min(ans, xMin**2 + yMin ** 2) 구하기
    **/
    private static int[][] arr;
    private static int ans = Integer.MAX_VALUE;
    private static int n;
    private static final int X_COOR = 0;
    private static final int Y_COOR = 1;
    private static final int COOR_SIZE = 2;

    public static void main(String[] args) throws IOException {
        initCoordinates();
        findMinXY();
        System.out.println(ans);
    }

    private static void findMinXY() {
        for (int i = 0; i < n; i++) { // i : 첫번째 점
            for (int j = i + 1; j < n; j++) { // j : 두번째 점
                int x1 = arr[i][X_COOR];
                int y1 = arr[i][Y_COOR];
                int x2 = arr[j][X_COOR];
                int y2 = arr[j][Y_COOR];
                int res = (int) (Math.pow(Math.abs(x2-x1), 2) + Math.pow(Math.abs(y2-y1), 2));
                ans = Math.min(ans, res);
            }
        }
    }

    private static void initCoordinates() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][COOR_SIZE];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())};
        }
        br.close();
    }
}
