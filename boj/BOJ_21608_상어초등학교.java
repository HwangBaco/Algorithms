package 알고리즘연습.boj;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교 {
    /*
    * 실행 시간 : 304 ms
    *
    * 메모리 : 26852 KB
    *
    * 시간복잡도 : O(N^4);
    * */
    private static List<int[]> li = new ArrayList<>();
    private static List<int[]> lli = new ArrayList<>();
    private static int ny, nx;
    private static int n;
    private static int[] visited;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    private static int[][] grid;
    private static HashMap<Integer, int[]> m = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new int[n];

        int ans = 0;

        for (int i = 0; i < (int) Math.pow(n, 2); i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            m.put(num, new int[]{a, b, c, d});
            li = new ArrayList<>();
            lli = new ArrayList<>();
            if (hasFriendsPos(a, b, c, d)) {
                getPos();
                grid[ny][nx] = num;
            } else if (hasSparsePos()) {
                getPos();
                grid[ny][nx] = num;
            } else {
                getPos();
                grid[ny][nx] = num;
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int res = 0;
                int[] pos = m.get(grid[y][x]);
                for (int i = 0; i < 4; i++) {
                    int tempY = y + dy[i];
                    int tempX = x + dx[i];
                    if (inRange(tempY, tempX)) {
                        res = getFriendCount(pos[0], pos[1], pos[2], pos[3], tempY, tempX, res);
                    }
                }
                ans += (int) Math.pow(10, res - 1);
            }
        }

//        testGrid();

        sb.append(ans);
        bw.write(sb.toString()); // 문자열 출력 only
        bw.flush();
        br.close();
        bw.close();
    }

    private static void testGrid() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("======================");
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static boolean hasFriendsPos(int a, int b, int c, int d) {
        int ans = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if ((visited[y] & 1 << x) != 0) {
                    continue;
                }
                int res = 0;
                for (int i = 0; i < 4; i++) {
                    int tempY = y + dy[i];
                    int tempX = x + dx[i];
                    if (inRange(tempY, tempX)) {
                        res = getFriendCount(a, b, c, d, tempY, tempX, res);
                    }
                    if (ans < res) {
                        ans = res;
                        li = new ArrayList<>();
                        li.add(new int[]{y, x});
                    } else if (ans == res) {
                        li.add(new int[]{y, x});
                    }
                }
            }
        }
        return li.size() == 1;
    }

    private static boolean hasSparsePos() {
        int ans = 0;
        for (int[] pos : li) {
            int res = 0;
            for (int i = 0; i < 4; i++) {
                int tempY = pos[0] + dy[i];
                int tempX = pos[1] + dx[i];
                if (inRange(tempY, tempX) && grid[tempY][tempX] == 0) {
                    res++;
                }
                if (ans < res) {
                    ans = res;
                    lli = new ArrayList<>();
                    lli.add(pos);
                } else if (ans == res) {
                    lli.add(pos);
                }
            }
        }
        return lli.size() == 1;
    }

    private static void getPos() {
        if (lli.isEmpty()) {
            ny = li.get(0)[0];
            nx = li.get(0)[1];
        } else {
            ny = lli.get(0)[0];
            nx = lli.get(0)[1];
        }
        visited[ny] |= 1 << nx;
    }

    private static int getFriendCount(int a, int b, int c, int d, int tempY, int tempX, int res) {
        if (grid[tempY][tempX] == a) {
            res++;
        } else if (grid[tempY][tempX] == b) {
            res++;
        } else if (grid[tempY][tempX] == c) {
            res++;
        } else if (grid[tempY][tempX] == d) {
            res++;
        }
        return res;
    }
}
