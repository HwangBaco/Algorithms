package 알고리즘연습.codetree.legacy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CodeTree_점개수세기2 {
    private static final int PS_SIZE = 2002;
    private static final int DOTS_SIZE = 1000;
    private static final int QUERY_COUNT = 100000;
    private static int n, q;
    private static TreeSet<Integer> ts = new TreeSet<>();
    private static HashMap<Integer, Integer> mapper = new HashMap<>();
    private static int[][] ps = new int[PS_SIZE][PS_SIZE];
    private static Pair[] dots = new Pair[DOTS_SIZE];
    private static Tuple[] queries = new Tuple[QUERY_COUNT];

    private static class Pair {
        int x, y;

        private Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Tuple {
        int x1, x2, y1, y2;

        private Tuple(int y1, int x1, int y2, int x2) {
            this.y1 = y1;
            this.x1 = x1;
            this.y2 = y2;
            this.x2 = x2;
        }
    }

    private static int getCeiling(int x) {
        if (ts.ceiling(x) != null) {
            return mapper.get(ts.ceiling(x));
        }
        return ts.size() + 1;
    }


    private static int getFloor(int x) {
        if (ts.floor(x) != null) {
            return mapper.get(ts.floor(x));
        }
        return 0;
    }

    private static int getAnswer(Tuple t) {
        int x1 = getCeiling(t.x1);
        int y1 = getCeiling(t.y1);

        int x2 = getFloor(t.x2);
        int y2 = getFloor(t.y2);

        return ps[y2][x2] - ps[y1 - 1][x2] - ps[y2][x1 - 1] + ps[y1 - 1][x1 - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        // init
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            ts.add(y);
            ts.add(x);
            dots[i] = new Pair(y, x);
        }

        // coordinates compression
        int idx = 1;
        for (Integer i : ts) {
            mapper.put(i, idx++);
        }

        // renew dots coordinates
        for (int i = 0; i < n; i++) {
            Integer newY = mapper.get(dots[i].y);
            Integer newX = mapper.get(dots[i].x);
            dots[i] = new Pair(newY, newX);
            ps[newY][newX]++; // init prefix sum
        }

        for (int i = 1; i < idx; i++) {
            for (int j = 1; j < idx; j++) {
                ps[i][j] += ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];
            }
        }


        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int answer = getAnswer(new Tuple(y1, x1, y2, x2));
            System.out.println(answer);
        }

        System.out.println();

    }
}
