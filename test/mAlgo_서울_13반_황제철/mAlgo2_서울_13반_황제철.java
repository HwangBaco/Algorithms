package 알고리즘연습.test.mAlgo_서울_13반_황제철;

import java.io.*;
import java.util.*;

public class mAlgo2_서울_13반_황제철 {
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		ArrayDeque<int[]> stack = new ArrayDeque<>();
		int ans = 0;
		for (int i = 1; i <= N; i++) { // 흐른 시간
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("1")) {
				// 새로운 작업 수행
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				if (T == 1) {
					// 바로 수행 가능한 경우
					ans += A;
				} else {
					// 할 일이 남은 경우
					stack.add(new int[] {A, T - 1});
				}
			} else if (!stack.isEmpty()) { // 새 작업이 주어지지 않은 상황에서, 할 일은 있는 경우
				int[] work = stack.pollLast();
				if (work[1] - 1 > 0) {
					stack.add(new int[] {work[0], work[1] - 1});
				} else {
					// 하던 일을 모두 끝낸 경우
					ans += work[0];
				}
			}			
		}
		System.out.println(ans);
		
	}
}
