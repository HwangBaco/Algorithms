package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {

    static final int PARSE_X = 1;
    static final int PARSE_Y = 2;
    static int X, Y;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        // prepare variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Shark> sharks = new ArrayList<>();
        Shark[][] arr = new Shark[Y][X];
        int ans = 0;

        // init data
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(y, x, speed, dir, size);
            sharks.add(shark);
            arr[y][x] = shark;
        }

        // start of business
        for (int fisherIdx = 0; fisherIdx < X; fisherIdx++) {
            // test only
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("=======================");

            // check the top shark.
            for (int i = 0; i < Y; i++) {
                // start from the top
                if (arr[i][fisherIdx] != null) {
                    Shark top = arr[i][fisherIdx];
                    ans += top.size;

                    sharks.remove(top);
                    arr[i][fisherIdx] = null;

                    break;
                }
            }

            sharks.stream().filter(Objects::nonNull).forEach(shark -> {
                int dir = shark.dir - 1;
                int y = shark.y;
                int x = shark.x;
                int speed = shark.speed;
                // 이동기
                int newY = (y + dy[dir] * speed);
                newY = move(newY, false);
                int newX = (x + dx[dir] * speed);
                newX = move(newX, true);
                sharks.add(new Shark(y, x, speed, dir, shark.size));
                sharks.remove(shark);
            });

            for (int i = 0; i < sharks.size(); i++) {
                Shark now = sharks.get(i);
                if (now != null) {

                    int dir = now.dir - 1;
                    int y = now.y;
                    int x = now.x;
                    int speed = now.speed;
                    int newY = (y + dy[dir] * speed);
                    newY = move(newY, false);
                    int newX = (x + dx[dir] * speed);
                    newX = move(newX, true);

                    // 위치 겹치면 잡아먹기
                    if (arr[newY][newX] != null) {
                        boolean swallow = arr[newY][newX].size < arr[y][x].size;
                        if (swallow) {
                            sharks.remove(now);
                            arr[newY][newX] = arr[y][x];
                        }
                        arr[y][x] = null;
                    }
                }

            }
        }

        System.out.println(ans);
    }

    public static int move(int pos, boolean isX) {
        int size = 0;
        int res = 0;
        int left = 0;
        if (isX) {
            size = X - 1;
            res = pos / X;
            left = pos % X;
        } else {
            size = Y - 1;
            res = pos / Y;
            left = pos % Y;
        }
        if (res > 0 && left > 0) { // 범위를 넘으면
            if (res % 2 == 0) {
                pos = Math.abs((pos % size) - size);
            } else {
                pos = (pos % size) == 0 ? size : pos % size;
            }
        } else if (res < 0 || pos < 0) {
            if (res % 2 == 0) {
                pos = Math.abs(pos % size);
            } else {
                pos = size - Math.abs(pos % size);
            }
        }
        return pos;
    }

    public static class Shark {
        int y, x, speed, dir, size;

        public Shark(int y, int x, int speed, int dir, int size) {
            this.y = y;
            this.x = x;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }

        @Override
        public String toString() {
            return "(" + this.size + ")";
        }

    }
}
