package 알고리즘연습.test.Algo_서울_13반_황제철;

import java.util.*;
import java.io.*;

public class Algo1_서울_13반_황제철 {
	// 단순 swap 구현
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 종이컵의 수
			int x = Integer.parseInt(st.nextToken()); // 간식이 들어있는 종이컵이 왼 쪽에서 몇번쨰인지 (간식 종이컵 좌표)
			int k = Integer.parseInt(st.nextToken()); // 컵 위치를 바꾸는 횟수
			
			HashMap<Integer, Integer> m = new HashMap<>();
			
			// init map
			for (int i = 1; i <= n; i++) {
				m.put(i, i);
			}
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int temp = m.get(b);
				m.replace(b, m.get(a));
				m.replace(a, temp);
//				System.out.println(m.get(a) + " " + m.get(b));
			}
			int ans = 0;
			for (int key : m.keySet()) {
				if (m.get(key) == x) {
					ans = key;
				}
			}
			
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
