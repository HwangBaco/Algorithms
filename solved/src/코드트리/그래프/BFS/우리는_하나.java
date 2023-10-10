package 코드트리.그래프.BFS;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 우리는_하나 {
    private static class Pair {
        private int x;
        private int y;

        private Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static boolean canGo(int y, int x, int prevY, int prevX) {
        return inRange(y, x) && canJump(y, x, prevY, prevX) && !isVisited[y][x];
    }

    private static boolean canJump(int y, int x, int prevY, int prevX) {
        int gap = Math.abs(cities[y][x] - cities[prevY][prevX]);
        return gap >= u && gap <= d;
    }

    private static void bfs() {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        while (!q.isEmpty()) {
            Pair crt = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = crt.x + dx[i];
                int newY = crt.y + dy[i];
                if (canGo(newY, newX, crt.y, crt.x)) {
                    isVisited[newY][newX] = true;
                    ans++;
                    q.add(new Pair(newY, newX));
                }
            }
        }
    }

    private static void go() {
        if (selected.size() == k) {
            for (Pair p : selected) {
                isVisited[p.y][p.x] = true;
                ans++;
                q.add(p);
            }
            bfs();
            pq.add(-ans);
            isVisited = new boolean[n][n];
            ans = 0;
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isSelected[i][j]) {
                    isSelected[i][j] = true;
                    selected.add(new Pair(i, j));
                    go();
                    isSelected[i][j] = false;
                    selected.remove(selected.size() - 1);
                }
            }
        }

    }

    private static int n, k, u, d;
    private static int ans = 0;

    private static int[][] cities;
    private static boolean[][] isSelected;
    private static boolean[][] isVisited;

    private static List<Pair> selected = new ArrayList<>();
    private static Queue<Pair> q = new LinkedList<>();
    private static Queue<Integer> pq = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        /*
        * nxn 격자
        * 각 칸에 높이 정보 주어짐 (0은 없음)
        * k개의 칸을 겹치지 않게 적절하게 골라, 골라진 칸으로부터 갈 수 있는 칸의 수가 최대일 떄의 숫자를 구하는 프로그램
        * 이동은 상하좌우, 두 도시간의 높이의 차가 u 이상 d 이하인 경우에만 가능
        *
        * 풀이:
        * 백트래킹으로 k개의 도시를 고른다. (중복이 없어야 하므로 selected[][] 활용)
        *
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        cities = new int[n][n];
        isVisited = new boolean[n][n];
        isSelected = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cities[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go();
        System.out.println(-pq.poll());
    }
}
