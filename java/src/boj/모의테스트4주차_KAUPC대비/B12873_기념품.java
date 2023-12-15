package 백준.모의테스트4주차_KAUPC대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class B12873_기념품 {
    public static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        n = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i + 1);
        }
        int cur = 0;
        for (int i = 1; i < n; i++) {
            m = arr.size();
            cur = (cur + ((i*i*i) - 1) % m) % m;
            arr.remove(cur);
        }
        System.out.println(arr.get(0));
    }
}
