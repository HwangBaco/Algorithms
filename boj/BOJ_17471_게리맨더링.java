package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
    /*
    * 실행 시간 : 144 ms
    *
    * 메모리 : 15144 KB
    * */
    static int[] parent;
    static int[] citizens;
    static int N; // 정점 개수
    static List<Integer>[] adj;

    static int ans = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        /* 시민 수 입력 */
        citizens = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            citizens[i] = Integer.parseInt(st.nextToken());
        }

        /* adj list 입력부 */
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int ea = Integer.parseInt(st.nextToken());
            for (int j = 0; j < ea; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        /*
        * 1. 부분집합을 구한다.
        *
        * 2. 구해진 부분집합을 기준으로 선거구로 가능한지 체크한다.
        * -> adj 리스트를 순회하면서 각 노드별로 연결된 노드 체크 (with visited)
        * -> 연결되어 있는 노드가 같이 선택된 경우 union 진행
        *
        * 3. 선택되지 않은 노드를 기준으로 선거구로 가능한지 체크한다.
        * -> 각 노드별로 adj 리스트를 순회하면서 연결된 노드 체크
        * -> 연결되어 있는 노드가 존재하면 union 진행
        *
        * 4. 선거구가 둘다 가능한 경우에는 : 인구수 차이 구해서 ans 갱신
        * */

        ps(1, 0); // 1번부터 고르냐 마냐 go
        System.out.println(ans == (int) 1e9 ? -1 : ans);
    }

    private static void ps(int depth, int visited) {
        if (depth == N + 1) {
            /* tree 연결관계 initialize */
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }
            /* 로직 수행 */
            for (int i = 1; i <= N; i++) {
                // 해당 노드를 골랐으면
                if ((visited & 1 << i) != 0) {
                    List<Integer> nodes = adj[i];
                    for (Integer v : nodes) {
                        // 같이 고른 놈이면
                        if ((visited & 1 << v) != 0) {
                            // 이미 인접한 노드들만 union 가능
                            // 즉, 나중에 find 검사할 때 root 노드가 다른 경우에는 선거구 불가 판단 가능
                            union(i, v);
                        }
                    }
                }
                // 해당 노드를 "NOT" 골랐으면
                else if ((visited & 1 << i) == 0) {
                    List<Integer> nodes = adj[i];
                    for (Integer v : nodes) {
                        // 같이 "NOT" 고른 놈이면
                        if ((visited & 1 << v) == 0) {
                            // 이미 인접한 노드들만 union 가능
                            // 즉, 나중에 find 검사할 때 root 노드가 다른 경우에는 선거구 불가 판단 가능
                            union(i, v);
                        }
                    }
                }
            } // end of 선거구 구성

            // 선거구 가능여부 체크
//            HashSet<Integer> hs = new HashSet<>();
            boolean aFirst = true;
            boolean bFirst = true;
            int aRoot = -1;
            int bRoot = -1;
            for (int i = 1; i <= N; i++) {
//                hs.add(find(i));
                if ((visited & 1 << i) != 0) {
                    if (aFirst) {
                        aRoot = find(i);
                        aFirst = false;
                        continue;
                    }
                    if (aRoot != find(i)) {
                        return;
                    }
                } else if ((visited & 1 << i) == 0) {
                    if (bFirst) {
                        bRoot = find(i);
                        bFirst = false;
                        continue;
                    }
                    if (bRoot != find(i)) {
                        return;
                    }
                }
            }
//            if (hs.size() != 2) {
//                return;
//            }
            int aCitizens = 0;
            int bCitizens = 0;
            for (int i = 1; i <= N; i++) {
                if ((visited & 1 << i) != 0) {
                    aCitizens += citizens[i];
                } else {
                    bCitizens += citizens[i];
                }
            }
            ans = Math.min(ans, Math.abs(aCitizens - bCitizens));
            return;
        }

        ps(depth + 1, visited | 1 << depth);
        ps(depth + 1, visited);
    }

    private static int find(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    private static void union(int u, int v) {
        int uRoot = find(u);
        int vRoot = find(v);
        if (uRoot == vRoot) {
            return;
        }
        if (uRoot < vRoot) {
            parent[vRoot] = uRoot;
        } else {
            parent[uRoot] = vRoot;
        }
    }
}
