package 코드트리.그래프.BFS;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 최소_경로로_탈출하기 {
    private static int n, m;
    private static int[][] visited;
    private static int[][] ans;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        // 2차원 배열 + 상하좌우
        // 뱀이 있는 칸 or 배열 크기를 벗어나는 방향으로 이동 불가 + visited[][] != 1
        // 탈출 가능 경로 최단 거리 -> 가중치가 동일하니 BFS
        // 이동 발걸음 수를 저장할 step, ans[][] 선언하여 이동하며 업데이트

        /*
        * 풀이 과정
        * 1. n, m 입력받는다.
        * 2. n번 loop :
        *   뱀이 없는 경우 1, 뱀이 있는 경우 0으로 2차원 배열 입력
        *
        * 3. BFS() :
        *   dx,dy 선언 ~ 상하좌우
        *   Queue<Pair> q = new LinkedList<>();
        *   q.add(new Pair(0,0));
        *   while(Queue에 Pair(현재 위치)가 있는 한):
        *       Pair p = q.poll();
        *       step++;
        *       for (0 <= i < 4):
        *           int x = p.x + dx[i];
        *           int y = p.y + dy[i];
        *           if( arr[x][y] == 1 && inRange(x,y) && visited[x][y] != 1):
        *               Pair newP = new Pair(x,y);
        *               q.add(newP);
        *               visited[x][y] = 1;
        *               ans[x][y] = step;
        *
        * 4. public class Pair {
        *       private int x;
        *       private int y;
        *
        *       public Pair(int x, int y):
        *           this.x = x;
        *           this.y = y;
        *   }
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        ans = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS();
        if (ans[n - 1][m - 1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans[n-1][m-1]);
        }



    }
    public static void BFS() {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (inRange(newX, newY) && visited[newX][newY] != 1 && arr[newX][newY] == 1) {
                    Pair newP = new Pair(newX, newY);
                    q.add(newP);
                    visited[newX][newY] = 1;
                    ans[newX][newY] = ans[x][y] + 1;
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
