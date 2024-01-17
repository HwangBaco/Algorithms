package 코드트리.그래프.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class K번_최댓값으로_이동하기 {
    /*
    * n, k
    * arr[][]
    * visited[][]
    * Queue<Pair>
    * ansNum, ansX, ansY
    * */
    private static int n, k;
    private static int[][] arr;
    private static int[][] visited;
    private static int startNum;
    private static int ansX, ansY, ansNum;
    private static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        /*
        * 자신 이하의 숫자 중 최대값을 찾아서 좌표를 저장
        * 위 과정을 k번 반복
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken())-1;
        int startX = Integer.parseInt(st.nextToken())-1;
        for (int i = 0; i < k; i++) {
            visited = new int[n][n];
            startNum = arr[startY][startX];
            Pair startPoint = new Pair(startY, startX);
            q.add(startPoint);
            ansY = n;
            ansX = n;
            ansNum = 0;
            bfs();
            if (ansY < n && ansX < n) {
                startY = ansY;
                startX = ansX;
            }
        }
        System.out.println((startY+1) + " " + (startX+1));
    }

    private static void bfs() {
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{1, 0, -1, 0};

        while (!q.isEmpty()) {
            Pair crt = q.poll();
            int crtX = crt.x;
            int crtY = crt.y;

            for (int i = 0; i < 4; i++) {
                int newX = crtX + dx[i];
                int newY = crtY + dy[i];
                if (canGo(newY, newX)) {
                    push(newY, newX);
                }
            }
        }
    }

    private static void push(int y, int x) {
        visited[y][x] = 1;
        if (ansNum < arr[y][x]) {
            ansY = y;
            ansX = x;
            ansNum = arr[y][x];
        } else if (ansNum == arr[y][x]) {
            if (y < ansY) {
                ansY = y;
                ansX = x;
                ansNum = arr[y][x];
            } else if (y <= ansY && x < ansX) {
                ansX = x;
                ansNum = arr[y][x];
            }
        }
        q.add(new Pair(y, x));
    }

    private static boolean canGo(int y, int x) {
        if (!inRange(y, x) || visited[y][x] == 1 || arr[y][x] >= startNum) {
            return false;
        }
        return true;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static class Pair {
        private int x;
        private int y;

        private Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }


}
