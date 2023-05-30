import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * DFS
 *
 * psuedo code
 n(노드 개수, 1000) , m(에지 개수)
 A(그래프 데이터 저장 인접 리스트)
 visited(방문 기록 저장 배열)

 for(n의 개수만큼 반복) {
    A 인접 리스트에 그래프 데이터 저장
 }
 --- 입력 종료

 --- 로직 시작
 for(n의 개수만큼 반복) {
    if (방문하지 않은 노드가 있으면) {
        연결 요소 개수++
        DFS 실행
    }
 }

 DFS {
    if (현재 노드 == 방문 노드) return;
    visited 배열에 현재 노드 방문 기록하기
    현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기(재귀 함수 형태)

 }
 */
public class B11724 {
    static boolean visited[];
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        arr = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer((br.readLine()));
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        bw.write(Integer.toString(count));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : arr[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
