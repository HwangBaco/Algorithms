package 코드트리.완전탐색.물체탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좌표평면_위의_특정_구역2 {
    private static int[][] arr;
    private static int minArea = Integer.MAX_VALUE;
    private static final int COORDINATES_SIZE = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][COORDINATES_SIZE];
        initArray(br, n);
        for (int i = 0; i < n; i++) { // i는 완전탐색 loop
            findMinArea(n, i);
        }
        System.out.println(minArea);
    }

    private static void findMinArea(int n, int i) {
    /*
    점 하나 제외하고
    나머지 세 점끼리 x길이, y길이 구하고
    Math.min으로 답 찾기
    **/
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) { // j는 제외하는 좌표 idx
            if (i == j) {
                continue;
            }
            xMin = Math.min(xMin, arr[j][0]);
            xMax = Math.max(xMax, arr[j][0]);
            yMin = Math.min(yMin, arr[j][1]);
            yMax = Math.max(yMax, arr[j][1]);
        }
        minArea = Math.min(minArea, (yMax - yMin) * (xMax - xMin));
    }

    private static void initArray(BufferedReader br, int n) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{a, b};
        }
    }
}
