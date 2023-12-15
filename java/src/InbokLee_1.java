import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class InbokLee_1 {
    static int n, m;
    static int[][] map;
    static int[][] dp;
    static int[] now;
    static boolean[][] visited;

    /*
    중요한 건, map은 이동할 때 꿀 값을 참고하는 용도일 뿐이다.
    map을 통해 길찾기를 수행(BFS), 매 이동에서 만약 칼럼이 이동될 때 쌓이는 값이 기존의 dp[][]값보다 크다면
    이를 반영해서 sout(dp[m][n]);을 하면 답이여야 한다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];
        dp[0][0] = map[0][0];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }


        /*
        now가 홀수일 때에는 (1,0), (0,1)로 움직일 수 있고,
        now가 짝수일 때에는 (1,1), (0,1)로 움직일 수 있다.
        * */

        bfs(0, 0);
        System.out.println(dp[m - 1][n - 1]);

    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            now = q.poll();
            visited[now[1]][now[0]] = true;

            if (now[1] % 2 == 1) {

            }
        }
    }
}
