package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {
    /*
    * 미친놈
    * */

    public static int n;

    public static Shark[][] arr;
    public static Shark[][] moved;
    public static int R, C;
    public static int ans;
    // 상어 움직이기
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new Shark[R][C];
        moved = new Shark[R][C];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(y, x, s, d, z);
            arr[y][x] = shark;
        }

        ans = 0;

        for (int pIdx = 0; pIdx < C; pIdx++) { // pIdx : 사람 위치, 시간
            // 사람이 움직이며 top shark 잡기
            fish(pIdx);

            // 움직임 배열 초기화
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    moved[i][j] = null;
                }
            }
            // 움직이고 잡아먹기
            for (int y = 0; y < R; y++) {
                for (int x = 0; x < C; x++) {
                    if (arr[y][x] != null) {
                        Shark shark = arr[y][x];
                        moveShark(shark);
                        swallow(shark);
                    }
                }
            }
            // 결과 반영
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    arr[i][j] = moved[i][j];
                }
            }
        }
        System.out.println(ans);
    }
    
    private static void moveShark(Shark shark) {
        int y = shark.y;
        int x = shark.x;
        int s = shark.speed;
        int d = shark.direction;
        int nx = x + dx[d] * s;
        int ny = y + dy[d] * s;

        // nx, ny는 음수일수도 있고, 양수일수도 있으며
        // 그 중에서 한번 넘어간 놈인지, 두번 넘어간 놈인지
        // 두번 넘어가면

        nx = move(nx, x, C);
        ny = move(ny, y, R);
        shark.y = ny;
        shark.x = nx;
        moved[ny][nx] = shark;
    }

    private static int move(int nx, int x, int C) {
        if (nx >= C) {
            nx = nx - x;
            if (nx / (C - 1) % 2 == 0) {
                nx = Math.abs((C - 1) - (nx % (C - 1)));
            } else if (nx / (C - 1) % 2 == 1) {
                nx = Math.abs(nx % (C - 1)) == 0 ? (C-1) : Math.abs((nx % (C - 1)));
            }
        } else if (nx < 0) {
            nx = nx + x;
            if (nx / (C - 1) % 2 == 0) {
                nx = Math.abs(nx % (C - 1)) == 0 ? (C-1) : Math.abs((nx % (C - 1)));
            } else if (nx / (C - 1) % 2 == 1) {
                nx = Math.abs((C - 1) - (nx % (C - 1)));
            }
        }
        return nx;
    }

    private static void swallow(Shark shark) {
        int y = shark.y;
        int x = shark.x;

        if (moved[y][x] != null) {
            moved[y][x] = moved[y][x].size > shark.size ? moved[y][x] : shark;
            System.out.println("SWALLOW");
        } else {
            moved[y][x] = shark;
        }
    }


    private static void fish(int x) {
        System.out.println("======" + x + "======");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        for (int y = 0; y < R; y++) {
            if (arr[y][x] != null) { // 상어가 있으면
                ans += arr[y][x].size;
                arr[y][x] = null;
                System.out.println("FISH!");
                return;
            }
        }
    }

    public static class Shark {
        int y, x, speed, direction, size;

        private Shark(int y, int x, int speed, int direction, int size) {
            this.y = y;
            this.x = x;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }

        @Override
        public String toString() {
            return "(" + this.speed +  ", " +  this.size + ")";
        }

    }
}
