package 알고리즘연습.test.mAlgo_서울_13반_황제철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class mAlgo1_서울_13반_황제철 {
	private static boolean[][] adj;
	private static boolean[] visited;
	private static int n, m;
	// 정점의 개수가 적으므로(최대 100개) 인접 행렬 선택
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		adj = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a][b] = true;
			adj[b][a] = true;
		}
		
		int res = bfs(1);
		
		System.out.println(res);		
		
	}
	private static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;
		int ans = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= n; i++) {
				if (adj[cur][i] && !visited[i]) {
					q.add(i);
					visited[i] = true;
					ans++;
				}
			}
		}
		
		return ans;
	}
}
