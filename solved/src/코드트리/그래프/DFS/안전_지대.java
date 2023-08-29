package 코드트리.그래프.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 안전_지대 {
    public static int n, m;
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};
    public static int[][] visited;
    public static int[][] grid;
    public static Map<Integer, Integer> map = new HashMap<>();
    public static int threshold;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        threshold = Integer.MIN_VALUE;
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                grid[i][j] = num;
                threshold = Math.max(threshold, num);
            }
        }
        map.put(1, 0); // edited
        for (int k = 1; k <= 100; k++) {
            if (k > threshold) {
                break;
            }
            visited = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (canGo(i, j, k)) {
                        map.put(k, map.getOrDefault(k, 0) + 1);
                        visited[i][j] = 1;
                        DFS(i, j, k);
                    }
                }
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println(entries.get(0).getKey() + " " + entries.get(0).getValue());

    }

    public static void DFS(int y, int x, int k) {
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (canGo(newY, newX, k)) {
                visited[newY][newX] = 1;
                DFS(newY, newX, k);
            }
        }
    }

    public static boolean canGo(int y, int x, int k) {
        if (!inRange(y, x) || grid[y][x] <= k || visited[y][x] == 1) {
            return false;
        }
        return true;
    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
