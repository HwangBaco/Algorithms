import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static char[][] grid;
    static boolean[][][][] visited;
    static int[] R, B, O;
    static int[] dy = {1, -1, 0, 0,};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new char[N][M];
        visited = new boolean[N][M][N][M]; // ry rx by bx
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'R') {
                    R = new int[]{i, j};
                } else if (grid[i][j] == 'B') {
                    B = new int[]{i, j};
                } else if (grid[i][j] == 'O') {
                    O = new int[]{i, j};
                }
            }
        }
        int ans = bfs();
        System.out.println(ans);

    }

    public static int bfs() {

        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[4]));
        q.add(new int[]{R[0], R[1], B[0], B[1], 0});
        visited[R[0]][R[1]][B[0]][B[1]] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int ry = now[0];
            int rx = now[1];
            int by = now[2];
            int bx = now[3];
            int cnt = now[4];
            if (cnt+1 > 10) {
                return -1;
            }
            for (int i = 0; i < 4; i++) {
                int[] nr = move(ry, rx, i);
                int[] nb = move(by, bx, i);
                int nry = nr[0];
                int nrx = nr[1];
                int nby = nb[0];
                int nbx = nb[1];
                if (visited[nry][nrx][nby][nbx]) {
                    continue;
                }
                if (grid[nby][nbx] == 'O') {
                    visited[nry][nrx][nby][nbx] = true;
                    continue;
                }
                if (grid[nry][nrx] == 'O') {
                    return cnt + 1;
                }
                if (nry == nby && nrx == nbx) {
                    if (nr[2] > nb[2]) {
                        nry -= dy[i];
                        nrx -= dx[i];
                    } else {
                        nby -= dy[i];
                        nbx -= dx[i];
                    }
                }
                q.add(new int[]{nry, nrx, nby, nbx, cnt + 1});
                visited[nry][nrx][nby][nbx] = true;
            }
        }
        return -1;
    }

    public static int[] move(int y, int x, int dir) {
        int cnt = 0;
        while (inRange(y,x) && (grid[y+dy[dir]][x+dx[dir]] != '#' && grid[y][x] != 'O')) {
            y += dy[dir];
            x += dx[dir];
            cnt++;
        }
        return new int[]{y, x, cnt};
    }

    public static boolean inRange(int y, int x) {
        return y >= 1 && y < N - 1 && x >= 1 && x < M - 1;
    }
}