package 코드트리.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class T0010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Std[] arr = new Std[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Std(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i+1);
        }
        Arrays.sort(arr, new Comparator<Std>() {
            @Override
            public int compare(Std o1, Std o2) {
                if (o1.height == o2.height) {
                    return o2.weight - o1.weight;
                }
                return o1.height - o2.height;
            }
        });
        for (Std s : arr) {
            System.out.println(s.height + " " + s.weight + " " + s.num);
        }
    }

    public static class Std {
        private int height;
        private int weight;

        public Std(int height, int weight, int num) {
            this.height = height;
            this.weight = weight;
            this.num = num;
        }

        private int num;

        public Std(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
}
