package 코드트리.그래프.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 돌_잘_치우기_2회차_오답 {
    private static int n, m, k;
    private static List<Pair> starts = new ArrayList<>();
    private static int step = 0;

    // for bfs
    private static int[][] arr;
    private static boolean[][] visited;
    private static Queue<Pair> movingQueue = new LinkedList<>();

    // for backtracking
    private static List<Pair> stonePositions = new ArrayList<>();
    private static boolean[][] selected;
    private static List<Pair> selectedStonePosList = new ArrayList<>();

    // for ans
    private static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        selected = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int isStone = Integer.parseInt(st.nextToken());
                if (isStone == 1) {
                    stonePositions.add(new Pair(i, j));
                }
                arr[i][j] = isStone;
            }
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            visited[y][x] = true;
            starts.add(new Pair(y, x));
        }
        pq.add(0);
        go();
        System.out.println(-pq.poll());
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static boolean canGo(int y, int x) {
        return inRange(y, x) && canPass(y, x) && !visited[y][x];
    }

    private static boolean canPass(int y, int x) {
        return arr[y][x] == 0 || selected[y][x];
    }

    private static void bfs() {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        step = movingQueue.size();
        while (!movingQueue.isEmpty()) {
            Pair crt = movingQueue.poll();
            for (int i = 0; i < 4; i++) {
                int newY = crt.y + dy[i];
                int newX = crt.x + dx[i];
                if (canGo(newY, newX)) {
                    visited[newY][newX] = true;
                    step++;
                    movingQueue.add(new Pair(newY, newX));
                }
            }
        }
        pq.add(-step);
    }

    private static void go() {
        if (selectedStonePosList.size() == m) {
            // 탐색
            movingQueue.addAll(starts);
            bfs();
            return;
        }
        for (Pair stonePos : stonePositions) {
            int y = stonePos.y;
            int x = stonePos.x;
            if (!selected[y][x]) {
                selected[y][x] = true;
                selectedStonePosList.add(stonePos);
                go();
                selected[y][x] = false;
                selectedStonePosList.remove(selectedStonePosList.size() - 1);
            }

        }

    }

    private static class Pair {
        private int x, y;

        private Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
