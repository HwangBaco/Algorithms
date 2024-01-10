package ssafy.사전학습.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 공통조상 {
    /*
    * 알고리즘 : 유니온파인드 + dfs
    * */
    public static int[] parent;
    public static int n, m;
    public static List<Integer> aList;
    public static List<Integer> bList;
    public static int cardinality;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 정점 개수
            m = Integer.parseInt(st.nextToken()); // 간선 개수
            int targetA = Integer.parseInt(st.nextToken()); // target A
            int targetB = Integer.parseInt(st.nextToken()); // target B
            cardinality = 0;
            parent = new int[n + 1];
            visited = new boolean[n + 1];
            for (int j = 0; j < n+1; j++) {
                parent[j] = j;
            }

            // init parent array
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int parentNode = Integer.parseInt(st.nextToken());
                int childNode = Integer.parseInt(st.nextToken());
                parent[childNode] = parentNode;
            }
            aList = new ArrayList<>();
            bList = new ArrayList<>();

            // commonRoot (fin)
            findRoot(targetA, aList);
            findRoot(targetB, bList);
            int aListSize = aList.size();
            int bListSize = bList.size();
            int root = -1;
            boolean isEnd = false;
            if (aListSize > bListSize) {
                for (int j = 0; j < aListSize; j++) {
                    Integer aElem = aList.get(j);
                    for (int k = 0; k < bListSize; k++) {
                        if (aElem.equals(bList.get(k))) {
                            root = aElem;
                            isEnd = true;
                            break;
                        }
                    }
                    if (isEnd) {
                        break;
                    }
                }
            } else {
                for (int j = 0; j < bListSize; j++) {
                    Integer bElem = bList.get(j);
                    for (int k = 0; k < aListSize; k++) {
                        if (bElem.equals(aList.get(k))) {
                            root = bElem;
                            isEnd = true;
                            break;
                        }
                    }
                    if (isEnd) {
                        break;
                    }
                }
            }

            // cardinality (fin)
            visited[root] = true;
            cardinality++;
            dfs(root);

            System.out.println("#" + i + " " + root + " " + cardinality);
        }
    }

    public static int findRoot(int target, List<Integer> li) {
        if (target == parent[target]) {
            return target;
        }
        li.add(parent[target]);
        return findRoot(parent[target], li);
    }

    /*
    * root 노드를 중심으로
    * 인접 리스트 관계를 parent에 담고 있으니,
    * parent를 활용하여 그래프 cardinality 탐색하면 되지 않을까?
    * DFS를 활용하자.
    * */

    public static void dfs(int v) {
        for (int i = 0; i < n + 1; i++) {
            if (!visited[i] && parent[i] == v) {
                cardinality++;
                visited[i] = true;
                dfs(i);
            }
        }
    }

}
