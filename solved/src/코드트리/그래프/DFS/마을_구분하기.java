package 코드트리.그래프.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 마을_구분하기 {
    public static int[] dc = new int[]{0, 1, 0, -1};
    public static int[] dr = new int[]{1, 0, -1, 0};
    public static int[][] visited;
    public static int[][] grid;
    public static int n;
    public static Queue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new int[n][n];
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (grid[j][k] == 1) {
                    grid[j][k] = 0;
                    TreeSet<Integer> ts = new TreeSet<>();
                    ts.add(0);
                    visited[j][k] = 1;
                    DFS(j, k, ts);
                    pq.add(ts.last());
                }
            }
        }
        int size = pq.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(pq.poll() + 1);
        }
        /*
        * grid를 dxdy를 통해 모든 좌표에 대하여 이동할 수 있으면 ans++를 거듭하며 사람의 수를 누적,
        * 사람 수를 priority queue에 저장한 후, ans를 0으로 초기화
        *
        * 출력할 때에는 pq의 사이즈 먼저 출력, 그리고 각 요소 출력
        **/
    }

    public static void DFS(int r, int c, TreeSet<Integer> ts) {
        for (int i = 0; i < 4; i++) {
            int newRow = r + dr[i];
            int newColumn = c + dc[i];
            if (canGo(newRow, newColumn)) {
                ts.add(ts.last() + 1);
                grid[newRow][newColumn] = 0;
                visited[newRow][newColumn] = 1;
                DFS(newRow, newColumn, ts);
            }
        }
    }

    public static boolean canGo(int r, int c) {
        if (!inRange(r, c)) {
            return false;
        }
        if (visited[r][c] == 1 || grid[r][c] == 0) {
            return false;
        }
        return true;
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

}
