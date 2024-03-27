package 알고리즘연습.boj;
import java.io.*;
import java.util.*;

public class Main { // 외판원순회
    static int N;
    static final int INF = (int) 1e9;
    static int[][] map, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][(1<<N)-1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i], -1);

        bw.write(go(0, 1)+"\n");
        bw.flush();
        br.close();
    }

    static int go(int now, int visit) {

        if(visit == (1<<N)-1) {
            if(map[now][0] == 0) return INF;
            return map[now][0];
        }

        if(dp[now][visit] != -1) return dp[now][visit];
        dp[now][visit] = INF;

        for(int i=0;i<N;i++) {
            if((visit & (1<<i)) == 0 && map[now][i] != 0) {
                dp[now][visit] = Math.min(go(i, visit | (1 << i)) + map[now][i], dp[now][visit]);   // 최소비용 갱신
            }
        }
        return dp[now][visit];
    }
}
