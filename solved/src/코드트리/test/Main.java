package 코드트리.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;
    private static int arr[][];
    private static Queue<Integer> pq = new PriorityQueue<Integer>();
    private static List<Integer> li = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        // 1이 골라지면 앞으로 123 가능
        // 2가 골라지면 234 가능
        // 3이 골라지면 345
        // 4가 골라지면 456
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2*n - 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2*i-1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, 0);

        // 백트래킹으로 숫자 고르기
        // 최대 값은 pq로 구하기?
    }

    private static void go(int m, int k) {
        if (li.size() == n) {
            int sum = li.stream().mapToInt(i->i).sum();
            pq.add(-sum);
            return;
        }
        for (int i = k; i < k + 3; i++) {
            li.add(arr[m][k]);
            go(m + 1, i);
            li.remove(li.size() - 1);
        }
            
    }


}
