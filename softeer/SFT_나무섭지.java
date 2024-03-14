package 알고리즘연습.softeer;

import java.io.*;
import java.util.*;

/**
 * @intuition
 * 일단 완탐일 것으로 보이는데 시간이 맞을지 봅시다.
 * # 주의할 점 : 탈출 불가능 조건은 (1) 유령을 만났을 때 (2) 벽 떄문에 도달할 수 없을 때
 * # 간단히 말해서, 유령은 움직이는 벽일 뿐임
 *
 * @simulation
 * 1. 배열 입력받음 (N * M)
 * 2. 남우 위치, 유령 위치 저장
 * 3. 남우는 출구 쪽으로 움직임. (남우는 최단거리로 이동하는 게 유령을 피할 수 있는 최선(이속이 같으니까)
 * 4. 유령들은 남우 쪽으로 움직임. (유령은 벽을 통과하는 게 사기임) - 안 움직여도 됨...
 * 5. 유령은 벽을 고려하지 않고 출구까지 거리를 계산, 남우는 벽을 고려하여 출구까지 거리를 계산
 * 6. 유령이 더 짧으면 남우는 못가는거임.
 * 7. 입력을 받을 때 유령의 최단거리와 남우의 이동거리를 계산하여 비교 namwoo[][] , ghost[][] 써서 최소값으로 갱신하면서 계산
 * 8. 만약  namwoo[dy][dx] > ghost[][] 면 return false; 이 때, namwoo[dy][dx]는 INF로 초기화 (도달 못하는 경우 고려)
 *
 * @algorithm bfs
 * @time O(N*M) : 남우와 고스트 1개의 출발점부터 bfs 탐색 1번씩
 * @memory O(N*M)
 */
public class SFT_나무섭지 {
    private static int N, M;
    private static int[][] map; // '.' : 0, 'D' : 1, '#' : 2, 'G' : 3, 'N' : 9
    private static final int EMPTY = 0;
    private static final int DEST = 1;
    private static final int WALL = 2;
    private static final int GHOST = 3;
    private static int nwY, nwX, destY, destX, ghostY, ghostX;
    private static int[][] gStep;
    private static int[][] nStep;
    private static boolean[][] visited;
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        gStep = new int[N][M];
        nStep = new int[N][M];

        List<int[]> ghosts = new ArrayList<>();
        // 맵 입력
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                String ss = s.substring(j, j + 1);
                // "." 비어있는 경우는 어차피 0으로 기록할 거라서 처리할 필요 없음
                 if (ss.equals("D")) {
                    map[i][j] = DEST;
                    destY = i;
                    destX = j;
                } else if (ss.equals("#")) {
                    map[i][j] = WALL;
                } else if (ss.equals("G")) {
                    map[i][j] = GHOST;
                    ghosts.add(new int[]{i, j});
                } else if (ss.equals("N")) {
                    // 남우가 움직일 때 장애물 여부를 판단하려고 맵을 보는 거니까 맵에 반영할 필요 없음
                    nwY = i;
                    nwX = j;
                }

                 nStep[i][j] = (int) 1e9;
                 gStep[i][j] = (int) 1e9;
            }
        }

        ghostY = (int) 1e9;
        ghostX = (int) 1e9;
        for (int[] ghost : ghosts) {
            int y = ghost[0];
            int x = ghost[1];
            int newDist = Math.abs(y - destY) + Math.abs(x - destX);
            int originDist = Math.abs(ghostY - destY) + Math.abs(ghostX - destX);
            if (originDist > newDist) {
                ghostY = y;
                ghostX = x;
            }
        }

        bfs(nwY, nwX, true);
        // 귀신은 dest와 맨해튼 거리가 가장 가까운 놈만 하자.
        bfs(ghostY, ghostX, false);

        br.close();
        bw.write(sb.append(nStep[destY][destX] < gStep[destY][destX] ? "Yes" : "No").toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int startY, int startX, boolean isHuman) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startY, startX});
        visited = new boolean[N][M];
        visited[startY][startX] = true;
        if (isHuman) {
            nStep[startY][startX] = 0;
        } else {
            gStep[startY][startX] = 0;
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (isHuman ? canGo(ny, nx) : canGhost(ny, nx)) {
                    if (isHuman) {
                        nStep[ny][nx] = Math.min(nStep[ny][nx], nStep[y][x] + 1);
                    } else {
                        gStep[ny][nx] = Math.min(gStep[ny][nx], gStep[y][x] + 1);
                    }
                    if (ny == destY && nx == destX) {
                        return;
                    }
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }

    private static boolean canGhost(int y, int x) {
        return inRange(y, x) && !visited[y][x];
    }
    private static boolean canGo(int y, int x) {
        return inRange(y, x) && map[y][x] <= 1 && !visited[y][x];
    }
    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
