package 코드트리.그래프.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 뿌요뿌요 {
    public static int n;
    public static int[][] grid;
    public static int[][] visited;
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};
    public static int count;
    public static TreeSet<Integer> treeSet = new TreeSet<>();
    public static int blockSize;
    public static boolean isBlock;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                if (canGo(i, j, num)) {
                    isBlock = false;
                    blockSize = 1;
                    treeSet.add(blockSize);
                    visited[i][j] = 1;
                    DFS(i, j, num);
                }
            }
        }
        System.out.println(count + " " + treeSet.last());

    }

    public static void DFS(int y, int x, int num) {
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (canGo(newY, newX, num)) {
                blockSize++;
                if (blockSize >= 4 && !isBlock) {
                    count++;
                    isBlock = true;
                }
                treeSet.add(blockSize);
                visited[newY][newX] = 1;
                DFS(newY, newX, num);
            }
        }
    }

    public static boolean canGo(int y, int x, int num) {
        if (!inRange(y, x) || grid[y][x] != num || visited[y][x] == 1) {
            return false;
        }
        return true;
    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
