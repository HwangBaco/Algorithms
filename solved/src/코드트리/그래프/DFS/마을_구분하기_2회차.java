package 코드트리.그래프.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 마을_구분하기_2회차 {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int cnt = 1;
    private static List<Integer> li = new ArrayList<>();
    private static Queue<Pair> q = new LinkedList<>();
    private static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        /*
        * 인접한 사람들은 같은 마을
        *
        * 총 마을의 개수와, 같은 마을에 있는 사람의 수를 오름차순으로 정렬하여 출력
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    q.add(new Pair(i, j));
                }
                arr[i][j] = num;
            }
        }
        for (Pair p : q) {
            if (canGo(p.y, p.x)) {
                visited[p.y][p.x] = true;
                dfs(p);
                li.add(cnt);
                cnt = 1;
            }
        }
        System.out.println(li.size());
        li.sort(Comparator.naturalOrder());

        for (int i = 0; i < li.size(); i++) {
            System.out.println(li.get(i));
        }

    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static boolean canGo(int y, int x) {
        return inRange(y,x) && arr[y][x] == 1 && !visited[y][x];
    }

    private static void dfs(Pair p) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int newY = p.y + dy[i];
            int newX = p.x + dx[i];
            if (canGo(newY, newX)) {
                visited[newY][newX] = true;
                cnt++;
                dfs(new Pair(newY, newX));
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
