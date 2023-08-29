package 코드트리.시뮬레이션.공간칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class T006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        boolean isOverT;
        List<Integer> li = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            isOverT = t < Integer.parseInt(st.nextToken());
            if (isOverT) {
                cnt++;
            } else {
                li.add(cnt);
                cnt = 0;
            }
        }
        li.add(cnt);
        int ans = li.stream().mapToInt(i -> i).max().orElseThrow(() -> new NoSuchElementException("no"));
        System.out.println(ans);
    }
}
