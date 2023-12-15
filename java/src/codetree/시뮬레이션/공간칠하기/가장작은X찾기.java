package 코드트리.시뮬레이션.공간칠하기;

import java.io.*;
import java.util.*;

public class 가장작은X찾기 {
    /*
    * 문제:
    * 양의 정수 x에 2를 곱하는 연산을 n번 반복
    * 1. 2를 곱할 때마다 매번 현재 숫자의 범위에 대한 단서 제공
    * 2. 가능한 x값 중 최솟값 구하는 프로그램 작성
    * */

    /*
    * 풀이:
    * n loop 아래에 주어지는 두 개의 수를 입력
    * 두 수를 2의 i제곱만큼 나누고 그 사이의 숫자를 ts과 비교하여, 중복되는 숫자들만 체크
    * 중복되는 숫자로만 다시 구성.
    * for loop 끝나면 ts.first() 출력
    * */
    private static int n;
    private static TreeMap<Integer, Integer> tm = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            Double a = Double.parseDouble(st.nextToken());
            Double b = Double.parseDouble(st.nextToken());
            int num = (int) Math.pow(2, i);
            int resA = (int) Math.ceil(a / num);
            int resB = (int) (b / num);
            for (int j = resA; j <= resB; j++) {
                tm.putIfAbsent(j, 0);
                tm.put(j, tm.get(j) + 1);
            }
        }
        for (Integer key : tm.keySet()) {
            if (tm.get(key) == n) {
                System.out.println(key);
                break;
            }
        }
    }
}
/*
*     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int a, b;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            for (int x = 1; x <= 10000; x++) {
                if (inRange(a, b, (int) (x * (Math.pow(2, i))))) {
                    set.add(x);
                } else {
                    set.remove(x);
                }
            }
        }
        System.out.println(set.first());
    }

    public static boolean inRange(int a, int b, int x) {
        return x >= a && x <= b;
    }
* */