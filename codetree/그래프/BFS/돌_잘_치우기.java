package 코드트리.그래프.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 돌_잘_치우기 {
    private static int n, m, k;
    private static int[][] arr;
    private static int ans;
    private static List<Pair> sPos = new ArrayList<>();
    private static List<Pair> stonePos = new ArrayList<>(); // 돌 위치 저장용 리스트
    private static List<Pair> selectedStones = new ArrayList<>(); // 백트래킹용 리스트
    private static Queue<Pair> q = new LinkedList<>();
    private static int[][] visited;
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    stonePos.add(new Pair(i, j));
                }
                arr[i][j] = num;
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken())-1;
            int startX = Integer.parseInt(st.nextToken())-1;
            sPos.add(new Pair(startY, startX));
        }

        for (Pair p : sPos) {
            go(p.y, p.x);
        }

        System.out.println(-pq.poll());
    }
    private static void go(int startY, int startX) {
        if (selectedStones.size() == m) {
            for (Pair p : selectedStones) {
                int x = p.x;
                int y = p.y;
                arr[y][x] = 0;
            }
            visited = new int[n][n];
            push(startY, startX);
            bfs();
            for (Pair p : selectedStones) {
                int x = p.x;
                int y = p.y;
                arr[y][x] = 1;
            }
            return;
        }

        for (Pair pair : stonePos) {
            selectedStones.add(pair);
            go(startY, startX);
            selectedStones.remove(selectedStones.size() - 1);
        }

    }

    private static void bfs() {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        ans = 1;
        while (!q.isEmpty()) {
            Pair crt = q.poll();
            int crtX = crt.x;
            int crtY = crt.y;
            for (int i = 0; i < 4; i++) {
                int newY = crtY + dy[i];
                int newX = crtX + dx[i];
                if (canGo(newY, newX)) {
                    push(newY, newX);
                }
            }
        }
        pq.add(-ans);
    }


    private static void push(int y, int x) {
        visited[y][x] = 1;
        ans++;
        q.add(new Pair(y, x));
    }

    private static boolean canGo(int y, int x) {
        return inRange(y, x) && visited[y][x] == 0 && arr[y][x] == 0;
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