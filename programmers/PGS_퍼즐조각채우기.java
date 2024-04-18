package 알고리즘연습.programmers;
import java.util.*;

/* conditions : 
 1. 퍼즐은 빈 칸에 딱 맞게만 둘 수 있음
 2. 퍼즐 조각은 회전 O / 뒤집기 X
 3. 게임 보드는 정사각형, 0 : 빈칸 , 1 : 채워진 칸
 4. 조각 테이블은 정사각형, 0 : 빈칸 , 1 : 조각이 있는 칸
 
 => 어차피 게임 보드에 둘 수 있는 조각은 딱 맞는 조각 뿐이라는 점이 포인트.
 => table에서 탐색한 조각과 딱 맞는 칸이 몇 개 있는가를 찾으면 될 듯? (=회전 가능 + 딱 맞게만 둘 수 있음)
    => table을 순회하면서 1로 구성된 퍼즐 조각의 위치들을 저장해둔 뒤, 각 퍼즐을 탐색하여 이동 경로 좌표를 저장해둠 (0,0) (0,1) (1,1) (-1,-1) + 회전 저장
    => 저장된 경로를 기준으로 game_board에서도 0으로 구성된 빈칸들의 위치에서 해당 좌표를 탐색할 때(y+0, x+0) (y+0, x+1) 1이 있는지 체크 / 가능하면 해당 좌표를 visited 처리
    => 이렇게 반복하여 가능한 경우 cnt 세기
 
 - 탐색은 bfs + PQ (좌상단부터) + visited
 
 @return 최대한 많은 조각을 채워 넣을 때, 총 몇 칸을 채울 수 있는가
**/
class PGS_퍼즐조각채우기 {
    int N;
    int cnt;
    boolean[][] visited;
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    List<List<int[]>> paths = new ArrayList<>();
    List<List<int[]>> blanks = new ArrayList<>();
    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        
        Queue<int[]> q = new ArrayDeque<>();
        ArrayList<int[]> path;
        int id = 0;
        for (int t = 0; t < 4; t++) {
            if (t > 0) {
                table = turnTable(table);
            }
            visited = new boolean[N][N];
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (table[y][x] > 0  && !visited[y][x]) {
                        id++;
                        // bfs 수행하여 퍼즐조각 path 담기
                        path = new ArrayList<>();
                        // 시작점은 i, j
                        q.add(new int[]{y, x});
                        visited[y][x] = true;
                        // queue 이용하여 bfs 탐색
                        while(!q.isEmpty()) {
                            int[] now = q.poll();
                            int nowY = now[0];
                            int nowX = now[1];
                            if (t == 0) {
                                table[nowY][nowX] = id;
                            }
                            path.add(new int[]{nowY - y, nowX - x, table[nowY][nowX]});
                            for (int i = 0; i < 4; i++) {
                                int ny = nowY + dy[i];
                                int nx = nowX + dx[i];
                                if (canGo(ny, nx, table, false)) {
                                    visited[ny][nx] = true;
                                    q.add(new int[]{ny, nx});
                                }
                            }
                        }
                        paths.add(path);
                    }
                }
            }
        }
        
        q.clear();
        ArrayList<int[]> blank;
        visited = new boolean[N][N];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (game_board[y][x] == 0 && !visited[y][x]) {
                    // bfs 수행하여 퍼즐조각 path 담기
                    blank = new ArrayList<>();
                    // 시작점은 i, j
                    q.add(new int[]{y, x});
                    visited[y][x] = true;
                    // queue 이용하여 bfs 탐색
                    while(!q.isEmpty()) {
                        int[] now = q.poll();
                        int nowY = now[0];
                        int nowX = now[1];
                        blank.add(new int[]{nowY - y, nowX - x});
                        for (int i = 0; i < 4; i++) {
                            int ny = nowY + dy[i];
                            int nx = nowX + dx[i];
                            if (canGo(ny, nx, game_board, true)) {
                                visited[ny][nx] = true;
                                q.add(new int[]{ny, nx});
                            }
                        }
                    }
                    blanks.add(blank);
                }
            }
        }
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        fff:
        for (int i = 0; i < blanks.size(); i++) {
            top:
            for (int j = 0; j < paths.size(); j++) {
                if (blanks.get(i).size() != paths.get(j).size()) {
                    continue;
                }
                if (map.getOrDefault(paths.get(j).get(0)[2], false)) {
                    continue;
                }
                int check = 0;
                next:
                for (int[] p : blanks.get(i)) {
                    for (int pdx = 0; pdx < paths.get(j).size(); pdx++) {
                        int[] pp = paths.get(j).get(pdx);
                        if (p[0] == pp[0] && p[1] == pp[1]) {
                            check++;
                            continue next;
                        }
                    }
                }
                if (check == blanks.get(i).size()) {
                    map.put(paths.get(j).get(0)[2], true);
                    cnt += blanks.get(i).size();
                    
                    continue fff;
                }
            }
        }

        return cnt;
    }
    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
    private boolean canGo(int y, int x, int[][] map, boolean isBoard) {
        return inRange(y, x) && (isBoard ? map[y][x] == 0 : map[y][x] > 0) && !visited[y][x];
    }
    private int[][] turnTable(int[][] table) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[N-j-1][i] = table[i][j];
            }
        }
        return temp;
    }
}
