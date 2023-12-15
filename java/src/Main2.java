import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// B5014
// 이따가 풀 것
public class Main2 {
    static boolean[] visited;
    static int ans;
    static int F, S, G, U, D;
    public static void main(String[] args) throws IOException {
        /*
        F : 건물의 총 높이
        S : 강호가 지금 있는 곳
        G : 가고자 하는 층
        U : 올라가는 간격
        D : 내려가는 간격

        강호가 목표 층에 도달하기 위해 눌러야 하는 버튼의 최솟값
        만약 도달할 수 없다면 "use the stairs" 출력

        psuedo code:
        1. F, S, G, U, D 입력 받는다.
        2. BFS(S);

        def BFS(i):
            1. 큐를 선언한다.
            2. 큐에 i를 넣는다.
            3. visited[i] = true;
            while (!queue.isEmpty()):
                int now = queue.poll();
                if now == G: return;
                // 올라가는 경우
                if (now > 0 and now + U < F and now < G and !visited[now + U]):
                    queue.offer(now+U);
                    visited[now+U] = true;
                    ans++;
                else if (now - D > 0 and now < F and now > G and !visited[now - D]):
                    queue.offer(now-D);
                    visited[now-D] = true;
                    ans++;
                else if (now > G and (G-now)%D != 0): sout("use the stairs"); return;
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new boolean[F];
        ans = 0;
        BFS(S);
    }

    private static void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now + U < F && now < G && !visited[now + U]) {
                queue.offer(now+U);
                visited[now+U] = true;
                ans++;
            } else if (D == 0 || now > G && (G - now) % D != 0) {
                System.out.println("use the stairs");
                return;
            } else if (now - D > 0 && now < F && now > G && !visited[now - D]) {
                queue.offer(now - D);
                visited[now - D] = true;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
