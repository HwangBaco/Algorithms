package 코드트리.시뮬레이션.공간칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class T003 {
    public static final int OFFSET = 1000;
    public static final int MAX_SIZE = 2000;
    public static void main(String[] args) throws IOException {
        int[][] arr = new int[MAX_SIZE + 1][MAX_SIZE + 1];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /*
        시간복잡도 : 최대 2000까지이므로 n^2 가능
        첫번째 사각형 : 각 좌표를 입력받아서 2차원 배열에 +1로 입력
        두번째 사각형 : 각 좌표를 입력받아서 2차원 배열에 +2로 입력
        브루트포스로 돌려서 1인 사각형의 x 최대 길이, y 최대 길이 확인
        -> 최대 길이로 하게 되면 r1을 가로지르는 r2에 대하여 대응하지 못함
        -> 따라서, 결국은 1로 남은 사각형의 x1y1, x2,y2를 구해야 함

        **/
        int x1,y1,x2,y2;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken()) + OFFSET;
            y1 = Integer.parseInt(st.nextToken()) + OFFSET;
            x2 = Integer.parseInt(st.nextToken()) + OFFSET;
            y2 = Integer.parseInt(st.nextToken()) + OFFSET;
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    if (i == 0) {
                        arr[j][k] += 1;
                    } else {
                        arr[j][k] += 2;
                    }
                }
            }
        }
        int minX = MAX_SIZE, maxX = 0, minY = MAX_SIZE, maxY = 0;
        boolean isExist = false;
        for (int i = 0; i <= MAX_SIZE; i++) {
            for (int j = 0; j <= MAX_SIZE; j++) {
                if (arr[i][j] == 1) {
                    isExist = true;
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        if (isExist) {
            System.out.println((maxX - minX + 1) * (maxY - minY + 1));
        } else {
            System.out.println(0);
        }
    }
}
