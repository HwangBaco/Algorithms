//package 알고리즘연습.swea.알고리즘수업;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class SWEA_벽돌깨기 {
//    private static int N,W,H;
//    private static int[] dy = {1, -1, 0, 0};
//    private static int[] dx = {0, 0, 1, -1};
//    private static int bricks;
//    private static int res;
//    private static int ans;
//    public static void main(String[] args) throws IOException {
//        // 구슬 골라서 터뜨리기 O(WH) 200
//        // 연쇄 폭발 O(WH) 200
//        // 중력 작용 O(WH) 200
//        // 위 과정을 N번 반복 O(N) 4
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//
//        // 처음에 벽돌 수 세고 시작
//        int T = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        for (int tc = 1; tc <= T; tc++) {
//            N = Integer.parseInt(st.nextToken());
//            W = Integer.parseInt(st.nextToken());
//            H = Integer.parseInt(st.nextToken());
//        }
//        int[][] map = new int[H][W];
//        for (int i = 0; i < H; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < W; j++) {
//                int num = Integer.parseInt(st.nextToken());
//                if (num > 0) {
//                    bricks++;
//                }
//                map[i][j] = num;
//            }
//        }
//
//        solution();
//
//        br.close();
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//    }
//
//    private static void solution() {
//        // 최초 구슬 하나 고르기
//    }
//
//    private static void simulation(int[][] map, int depth) {
//        if (depth == N) {
//            // 정답 저장
//            ans = Math.min((bricks - res), ans); // 이번 결과 vs 기존 결과
//            return;
//        }
//        for (int i = 0; i < W; i++) {
//            // w 좌표마다 시뮬이 돌아가는 거임. 시작 전에 복사한 뒤
//            int[][] copyMap = new int[H][W];
//            for (int k = 0; k < H; k++) {
//                copyMap[k] = map[k].clone();
//            }
//            // 실행
//            for (int j = 0; j < H; j++) {
//                if (copyMap[i][j] > 0) {
//                    copyMap
//                    bomb(copyMap, i, j); // dfs로 연쇄 폭발 반영 on copyMap
//                    simulation(copyMap, depth + 1); // 그 copyMap에서 다시 시뮬 진행
//                    break; // 가장 위에꺼만 터뜨리면 되니까
//                }
//            }
//        }
//    }
//
//
//    // 특정 좌표 터뜨리기
//    // 사정거리 내 좌표 전부 터뜨리기
//    // dfs
//    // depth의 수 == 터뜨린 수
//    private static void bomb(int[][] map, int y, int x, int depth) {
//        int range = map[y][x] - 1;
//        map[y][x] = 0;
//        for (int i = 1; i <= range; i++) {
//            for (int j = 0; j < 4; j++) {
//                int ny = y + dy[j]*i;
//                int nx = x + dx[j]*i;
//                if (inRange(ny, nx)) {
//                    bomb(map, ny, nx);
//                }
//            }
//        }
//
//    }
//
//    private static boolean inRange(int y, int x) {
//        return y >= 0 && y < H && x >= 0 && x < W;
//    }
//}
