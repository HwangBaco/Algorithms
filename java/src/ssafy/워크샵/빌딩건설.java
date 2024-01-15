package ssafy.워크샵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 패키지 : com.ssafy.ws.step3
// 클래스명 : Solution
public class 빌딩건설 {
    public static int n;
    public static final int BUILDING = 1;
    public static final int GREEN = 0;
    public static int height;
    public static void main(String[] args) throws IOException {
        /*
        * 빌딩을 세울 수 있는 곳은 B
        * 공원조성단지는 G
        * 인접 반경은 8방으로 탐색하여 G가 없는 경우에 빌딩을 세우는데, 높이는 가로 세로를 전부 탐색하여 포함하는거임
        * 만약 이런 곳이 없으면 2가 답임
        * B가 없으면 0이 답임
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    String s = st.nextToken();
                    arr[j][k] = (s.equals("B")? 1 : 0);
                }
            }

            Queue<Integer> pq = new PriorityQueue<>();
            pq.add(0);
            boolean isBuilding = false;
            int[] dx = new int[]{1, 1, 0, -1, -1, 0, 1, -1};
            int[] dy = new int[]{1, 0, 1, -1, 0, -1, -1, 1};
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    // 현재 좌표 (j, k)
                    if (arr[y][x] == BUILDING) {
                        boolean hasGreen = false;
                        for (int l = 0; l < 8; l++) {
                            int newX = x + dx[l];
                            int newY = y + dy[l];
                            if (inRange(newY, newX)) {
                                if (arr[newY][newX] == GREEN) {
                                    hasGreen = true;
                                }
                            }
                        }
                        if (hasGreen) {
                            pq.add(-2);
                        } else {
                            height = 1;
                            for (int j = 0; j < 4; j++) {
                                go(y, x, arr, j);
                            }
                            pq.add(-height);
                            // 인근 가로세로 빌딩 부지 개수 세기
                            // pq.add(-인근빌딩부지개수)
                        }
                    }
                }
            }
            System.out.println("#" + i + " " + -pq.poll());

        }

    }

    public static void go(int y, int x, int[][] arr, int direction) {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int newX = x + dx[direction];
        int newY = y + dy[direction];
        if (inRange(newY, newX)) {
            if (arr[newY][newX] == BUILDING) {
                height++;
            }
            go(newY, newX, arr, direction);
        }

    }
    public static boolean inRange(int y, int x) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

}
