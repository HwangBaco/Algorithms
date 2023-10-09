package 코드트리.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static Queue<Pair> q = new LinkedList<>();
    private static int[][] arr;
    private static int[][] visited;
    private static int n;
    private static int r1,r2,r3,c1,c2,c3;
    private static boolean two = false;
    private static boolean three = false;
    public static void main(String[] args) throws IOException {
        /*
        * -- 문제 해석 --
        * 0,1 숫자로만 이루어진 n  n 크기의 격자 (0 : 빈 곳, 1 : 사람이 사는 곳)
        * 상하좌우 이동하여 1로 연결된 곳은 같은 마을
        * 3개의 좌표가 주어질 때, 이 놈들이 서로 같은 마을에 살고 있는지 판단하는 프로그램
        * */
        /*
        * -- 문제 풀이 --
        * 격자 첫 번째 위치에서 BFS 돌려서
        * 두 번째, 세 번째가 포착되는지 확인
        * 둘 다 포착 되면 true
        * 포착 안되면 false
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken())-1;
        c1 = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken())-1;
        c2 = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine());
        r3 = Integer.parseInt(st.nextToken())-1;
        c3 = Integer.parseInt(st.nextToken())-1;
        push(r1, c1);
        bfs();
        System.out.println(two && three ? 1 : 0);
    }
    private static void bfs() {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        while (!q.isEmpty()) {
            Pair crt = q.poll();
            int x = crt.x;
            int y = crt.y;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (canGo(newY, newX)) {
                    push(newX, newY);
                }
            }
        }
    }

    private static void push(int newX, int newY) {
        visited[newY][newX] = 1;
        if (newY == r2 && newX == c2) {
            two = true;
        } else if (newY == r3 && newX == c3) {
            three = true;
        }
        q.add(new Pair(newY, newX));
    }

    private static boolean canGo(int y, int x) {
        return inRange(y,x) && visited[y][x] == 0 && arr[y][x] == 1;
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
