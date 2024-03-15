//package 알고리즘연습.softeer;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class SFT_로봇이이동한거리 {
//    private static int N, M, res, courseLength;
//    private static boolean[][] map;
//    private static boolean[][] visited;
//    private static final boolean ROAD = true;
//    private static final boolean WALL = false;
//    private static Queue<int[]> q = new ArrayDeque<>();
//    private static Queue<Integer> track = new ArrayDeque<>();
//    private static int[] dy = {-1, 0, 1, 0}; // 상 좌 하 우
//    private static int[] dx = {0, -1, 0, 1};
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        map = new boolean[N+1][M+1];
//        int ansY = -1;
//        int ansX = -1;
//        int ansDir = -1;
//        Queue<Integer> ansTrack = new ArrayDeque<>();
//        for (int y = 1; y <= N; y++) {
//            String s = br.readLine();
//            for (int x = 1; x <= M; x++) {
//                String ss = s.substring(x, x + 1);
//                if (ss.equals("#")) {
//                    map[y][x] = ROAD;
//                    q.add(new int[]{y, x});
//                    courseLength++;
//                } else {
//                    map[y][x] = WALL;
//                }
//            }
//        }
//        for (int[] start : q) {
//            visited = new boolean[N + 1][M + 1]; // init
//            int y = start[0];
//            int x = start[1];
//            for (int dir = 0; dir < 4; dir++) {
//                res = 0;
//                dfs(y, x, dir);
//                if (res >= courseLength && ansTrwack.size() > track.size()) {
//                    ansDir = dir;
//                    ansTrack.addAll(track);
//                    ansY = y;
//                    ansX = x;
//                }
//            }
//        }
//    }
//
//    private static void dfs(int y, int x, int dir) {
//
//    }
//    private static boolean canGo(int y, int x) {
//        return inRange(y,x) && map[y][x] && !visited[y][x];
//    }
//
//    private static boolean inRange(int y, int x) {
//        return x >= 1 && x <= M && y >= 1 && y <= N;
//    }
//}
