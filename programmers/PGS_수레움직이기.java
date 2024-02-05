package 알고리즘연습.programmers;

public class PGS_수레움직이기 {
    class Solution {
        boolean redEnd = false;
        boolean blueEnd = false;
        int[][] arr;
        boolean[][][] visited;
        final int RED = 0;
        final int BLUE = 1;
        int n, m;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        public class Pair {
            int x, y;
            public Pair(int y, int x) {
                this.y = y;
                this.x = x;
            }
        }

        public int solution(int[][] maze) {
            n = maze.length;
            m = maze[0].length;
            arr = new int[n][m];
            visited = new boolean[2][n][m];
            Pair red = null;
            Pair blue = null;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = maze[i][j];
                    if (maze[i][j] == 1) {
                        red = new Pair(i, j);
                    } else if (maze[i][j] == 2) {
                        blue = new Pair(i, j);
                    }
                }
            }
            visited[RED][red.y][red.x] = true;
            visited[BLUE][blue.y][blue.x] = true;
            int answer = go(red, blue, 0);

            return (answer == (int) 1e9) ? 0 : answer;
        }

        private boolean canGo(Pair cntRed, Pair red,
                              Pair cntBlue, Pair blue){
            // inRange && no wall
            if(red.x < 0 || red.y < 0 || red.x >= m || red.y >= n
                    || blue.x < 0 || blue.y < 0 || blue.x >= m || blue.y >= n
                    || arr[red.y][red.x] == 5 || arr[blue.y][blue.x] == 5) {
                return false;
            }

            // no switch position
            if((cntRed.x == blue.x && cntRed.y == blue.y)
                    && (cntBlue.x == red.x && cntBlue.y == red.y)) {
                return false;
            }

            // no duplicate visit 'til on dest
            if((!redEnd && visited[RED][red.y][red.x])
                    || (!blueEnd && visited[BLUE][blue.y][blue.x])) {
                return false;
            }
            // no same spot
            if(red.x == blue.x && red.y == blue.y) {
                return false;
            }
            return true;
        }

        public int go(Pair red, Pair blue, int result) {
            if  (redEnd && blueEnd) {
                return result;
            }

            int answer = (int) 1e9;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    Pair nRed = red;
                    Pair nBlue = blue;
                    if (!redEnd) {
                        nRed = new Pair(red.y + dy[i], red.x + dx[i]);
                    }
                    if (!blueEnd) {
                        nBlue = new Pair(blue.y + dy[j], blue.x + dx[j]);
                    }

                    if (!canGo(red, nRed, blue, nBlue)) {
                        continue;
                    }
                    visited[RED][nRed.y][nRed.x] = true;
                    visited[BLUE][nBlue.y][nBlue.x] = true;
                    redEnd = (arr[nRed.y][nRed.x] == 3) ? true : false;
                    blueEnd = (arr[nBlue.y][nBlue.x] == 4) ? true : false;

                    answer = Math.min(answer, go(nRed, nBlue, result+1));

                    visited[RED][nRed.y][nRed.x] = false;
                    visited[BLUE][nBlue.y][nBlue.x] = false;
                    redEnd = false;
                    blueEnd = false;
                    //}
                }
            }
            return answer;
        }
    }
}
