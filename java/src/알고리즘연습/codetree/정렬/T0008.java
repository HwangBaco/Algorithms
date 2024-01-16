package 코드트리.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class T0008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Coordinate[] arr = new Coordinate[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Coordinate(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                return (Math.abs(o1.x) + Math.abs(o1.y)) - (Math.abs(o2.x) + Math.abs(o2.y));
            }
        });
        for (Coordinate c : arr) {
            System.out.println(c.num);
        }
    }

    public static class Coordinate {
        private int num;
        private int x;
        private int y;

        public Coordinate(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
}
