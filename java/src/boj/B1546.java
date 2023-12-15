package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            li.add(Integer.parseInt(st.nextToken()));
        }
        int max = li.stream()       // 리스트 객체로 스트림 객체를 생성
                .mapToInt(v -> v)   // Integer 스트림을 얻어냄
                .max()              // max 값을 얻어냄
                .orElseThrow(NoSuchElementException::new);  // 결과값이 null일 경우 exception
        double[] _li = li.stream()
                .mapToDouble(i -> i)
                .map(i -> i * 100 / max)
                .toArray();
        double sum = Arrays.stream(_li).sum();
        double ans = (sum / n);
        System.out.println(ans);
    }
}
