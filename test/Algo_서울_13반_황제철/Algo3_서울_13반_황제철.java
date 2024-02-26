package 알고리즘연습.test.Algo_서울_13반_황제철;

import java.io.*;
import java.util.*;

public class Algo3_서울_13반_황제철 {
	// bfs 시뮬레이션
	private static String[][] arr;
	private static int R, C;
	private static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[R][C];
		visited = new boolean[R][C];
		
		int[][] humans = new int[2][2];
		int humanCnt= 0;
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				String ss = s.substring(j,j+1);
				if (ss.equals("L")) {
					// 인간 좌표 저장
					humans[humanCnt][0] = i;
					humans[humanCnt][1] = j;
					humanCnt++;
				}
				arr[i][j] = ss;
			}
		}
		
		int day = 0;

		
		// 플러드필을 이용한 시뮬레이션을 통해 빙하를 매 턴마다 녹임.
		// 녹은 빙하를 기준으로 인간 좌표를 bfs로 이동하면서 step 기록
		while(true) {
			int[] dx = {0, 1, 0, -1};
			int[] dy = {1, 0, -1, 0};
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					
				}
			}
			
		}
		
		
	}
	
	private static boolean canLand(int y, int x) {
		return inRange(y,x) && arr[y][x].equals("X");
	}
	
	private static boolean canGo(int y, int x) {
		return inRange(y,x) && arr[y][x].equals(".") && !visited[y][x];
	}
	
	private static boolean inRange(int y, int x) {
		return y < R && y >= 0 && x < C && x >= 0;
	}
}
