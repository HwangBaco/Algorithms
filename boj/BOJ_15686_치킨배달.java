package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
    static int ans = (int) 1e9;
    static List<int[]> chickens;
    static List<int[]> homes;
    static List<int[]> selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        chickens = new ArrayList<>();
        homes = new ArrayList<>();
        selected = new ArrayList<>();

        boolean[] visited = new boolean[13];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    homes.add(new int[]{i, j});
                } else if (num == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        // 조합으로 치킨집 m개 선정하고
        comb(0, 0, m, visited);

        // 조합 finish 분기에서 home과의 맨해튼 거리 res를 구해서 ans와 min 연산

        System.out.println(ans);
    }

    private static void comb(int depth, int cnt, int m, boolean[] visited) {
        if (cnt == m) {
            // homes 리스트 순회하면서 선택된 치킨집들과 맨해튼 거리 구해서 res에 전부 sum
            int sum = 0;
            for (int[] home : homes) {
                int dist = (int) 1e9;
                for (int[] chicken : selected) {
                    int tmp = Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
                    dist = Math.min(dist, tmp);
                }
                sum += dist;
            }
            ans = Math.min(ans, sum);
        }

        if (depth == chickens.size()) {
            return;
        }

        if (!visited[depth]) {
            visited[depth] = true;
            selected.add(chickens.get(depth));
            comb(depth+1, cnt+1, m, visited);
            visited[depth] = false;
            selected.remove(selected.size() - 1);
            comb(depth+1, cnt, m, visited);
        }

    }

}
