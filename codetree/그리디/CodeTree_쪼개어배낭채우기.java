package 알고리즘연습.codetree.그리디;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CodeTree_쪼개어배낭채우기 {
    /*
    * fractional knapsack -> greedy
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Jewel[] arr = new Jewel[n];

        // 쪼갤 수 있으니까 결국 무게 당 가격이 높은 걸 최대한 많이 담고, 남는 공간에 다음 가치를 담자.
        // => 그리디

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double w = Integer.parseInt(st.nextToken());
            double v = Integer.parseInt(st.nextToken());
            arr[i] = new Jewel(w, v);
        }
        Arrays.sort(arr, Comparator.comparingDouble(o -> -o.value/o.weight)); // 단위 가치 내림차순

        double ans = 0;
        double bag = 0;

        for (Jewel jewel : arr) {
            double weight = jewel.weight;
            double value = jewel.value;
            if (bag + weight <= m) {
                ans += value;
                bag += weight;
            } else {
                double fractionValue = (value * (m - bag)) / weight;
                ans += fractionValue;
                break;
            }
        }
        bw.write(String.format("%.3f", ans));

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Jewel {
        double weight;
        double value;

        private Jewel(double w, double v) {
            weight = w;
            value = v;
        }
    }
}
