package ssafy.사전학습;
import java.util.Scanner;
import java.io.*;
import java.util.*;

class 파핑파핑_지뢰찾기
{
    public static int n;
    public static String[][] arr;
    public static boolean[][] isVisited;

    public static void main(String args[]) throws Exception
    {
		/*
			1. n x n 배열로 입력 받는다.

			2. 8방에 전부 지뢰가 없는 경우, 상하좌우 열을 검사(visited), 거기도 8방에 전부 지뢰가 없는 경우, 상하좌우 열을 검사(visited),
			반복해서 인근 땅 전부 검사 (전체 배열 검사) ; 재귀 이용

			3. 그리고 나서 지뢰가 아니면서 visited가 아닌 땅 전부 카운트

.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            // init array
            arr = new String[n][n];
            isVisited = new boolean[n][n];
            for (int i = 0; i < n; i ++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.substring(j, j + 1);
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!hasMine(i, j) & !isVisited[i][j]) {
                        cnt += isOk(i, j);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!hasMine(i, j) && !isVisited[i][j]) {
                        cnt++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + cnt);
        }
    }
    public static int isOk(int y, int x) {
        int[] dx = new int[]{1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = new int[]{0, -1, 0, 1, 1, -1, 1, -1};
        for (int i = 0; i < 8; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (inRange(newY, newX) && hasMine(newY, newX)) {
                return 0;
            }
        }
        isVisited[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (inRange(newY, newX) && !hasMine(newY, newX) && !isVisited[newY][newX]){
                isVisited[newY][newX] = true;
                isOk(newY, newX);
            }
        }
        return 1;
    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    public static boolean hasMine(int y, int x) {
        return arr[y][x].equals("*");
    }
}