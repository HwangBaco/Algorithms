package ssafy.알고리즘.사전학습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static List<Cdn> parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) + 2;
            st = new StringTokenizer(br.readLine());
            Cdn[] arr = new Cdn[n];
            List<Pair> adj = new ArrayList<>();
            parent = new LinkedList<>();
            int x, y;
            for (int j = 0; j < n; j++) {
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                arr[j] = new Cdn(x, y);
            }
            for (int j = 0; j < n; j++) {
                parent.add(arr[j]);
            }
            for (int j = 0; j < n - 1; j++) {
                for (int k = 1; k < n; k++) {
                    int dis = Math.abs(arr[j].y - arr[k].y) + Math.abs(arr[j].x - arr[k].x);
                    adj.add(new Pair(dis, arr[j], arr[k]));
                }
            }
            // end of init
            adj.sort((o1, o2) -> o2.dis - o1.dis);

            int res = 0;
            for (Pair pair : adj) {
                if (find(pair.a) != find(pair.b)) {
                    union(pair.a, pair.b);
                    res += pair.dis;
                }
            }
            System.out.println("#" + i + " " + res);
        }
    }

    public static class Pair {
        Cdn a, b;
        int dis;

        public Pair(int dis, Cdn a, Cdn b) {
            this.dis = dis;
            this.a = a;
            this.b = b;
        }
    }

    public static class Cdn {
        int x, y;

        public Cdn(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Cdn find(Cdn v) {
        System.out.println("v.x = " + v.x);
        System.out.println("v.y = " + v.y);
        System.out.println("indexOf(v) = " + indexOf(v));
        if (parent.get(indexOf(v)).equals(v)) {
            return v;
        }
        parent.set(indexOf(v), find(parent.get(indexOf(v))));
        System.out.println("indexOf(v) = " + indexOf(v));
        return parent.get(indexOf(v));
    }

    private static int indexOf(Cdn v) {
        return parent.indexOf(v);
    }

    public static void union(Cdn a, Cdn b) {
        a = find(a);
        b = find(b);

        if (a.y < b.y) {
            parent.set(indexOf(a), b);
        } else {
            parent.set(indexOf(b), a);
        }
    }

}
