package 알고리즘연습.boj;

import java.io.IOException;

/**
 * @intuition 경우의 수 저장 배열 선언하고, 이동 가능하면 경우의 수 배열 갱신
 *
 * @algorithm bfs + dp
 * @time O(NM) bfs탐색하면서 dp 저장하는게 전부
 * @memory
 */
public class BOJ_1520_내리막길 {
    private static int[][] map; // 높이 저장
    private static int[][] dp; // 해당 위치로 이동할 수 있는 최대 경우의 수
    private static int M, N; // M : 세로 , N : 가로 (500이하 자연수)
    private static int H; // 정답 (이동 가능한 경로의 수 - 10억 이하의 음이 아닌 정수);
    public static void main(String[] args) throws IOException {

    }
}
