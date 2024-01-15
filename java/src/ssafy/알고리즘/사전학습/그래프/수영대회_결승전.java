package ssafy.알고리즘.사전학습.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 수영대회_결승전 {

    public static int n;
    public static int[][] arr;
    public static int[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            ans = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    ans[j][k] = Integer.MAX_VALUE;
                }
            }
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            bfs(new Node(startY, startX));
            if (ans[endY][endX] == Integer.MAX_VALUE) {
                System.out.println("#" + i + " " + -1);
            } else {
                System.out.println("#" + i + " " + ans[endY][endX]);
            }
        }
    }

    public static void bfs(Node start) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        ans[start.y][start.x] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int y = now.y;
            int x = now.x;

            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                if (canGo(newY, newX)) {
                    if (arr[newY][newX] == 2) {
                        int res = ans[y][x] + Math.abs((ans[y][x] % 3) - 2) + 1;
                        if (res > ans[newY][newX]) {
                            continue;
                        }
                        ans[newY][newX] = res;
                    } else {
                        int res = ans[y][x] + 1;
                        if (res > ans[newY][newX]) {
                            continue;
                        }
                        ans[newY][newX] = res;
                    }
                    q.add(new Node(newY, newX));
                }
            }
        }
    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    public static boolean canGo(int y, int x) {
        return inRange(y, x) && arr[y][x] != 1;
    }

    public static class Node {
        int x, y;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
