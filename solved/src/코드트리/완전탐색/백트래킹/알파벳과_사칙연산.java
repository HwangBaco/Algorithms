package 코드트리.완전탐색.백트래킹;

import java.io.*;
import java.util.*;

public class 알파벳과_사칙연산 {
    private static List<Integer> li = new ArrayList<>();
    private static Queue<Integer> pq = new PriorityQueue<>();
    private static String fomula;


    public static void main(String[] args) throws IOException {
        /*
        * + : 43, - : 45, * : 42
        * */
        /*
         * a,b,c,d,e,f가 여러개 등장할 경우에는 각 미지수에 적합한 숫자를 할당하는 것이 중요
         * 완탐으로 조합을 탐색하는데, 백트래킹으로 a,b,c,d,e,f 각각에 1~4를 배정한 뒤
         * 그 조합에 따른 결과값을 PQ에 넣구, 최대 결과를 출력(PQ.poll())하면 될듯.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fomula = br.readLine();
        go();
        System.out.println(-pq.poll());

    }

    private static void go() {
        if (li.size() == 6) {
            insertResult();
            return;
        }
        /*
        * a,b,c,d,e,f 각각에 해당하는 1~4 숫자 조합 배정
        * */
        for (int i = 1; i <= 4; i++) {
            li.add(i);
            go();
            li.remove(li.size() - 1);
        }
    }
    private static void insertResult() {
        /*
        * 조합에 따른 결과를 연산하고 pq에 추가
        * */
        String[] split = fomula.split("");
        int res = 0;
        String op = "";
        for (String s : split) {
            int ascii = (int) s.charAt(0);
            if (ascii >= 97 && ascii <= 122) {
                int operand = li.get(ascii - 97);
                if (op.equals("+") || op.equals("")) {
                    res += operand;
                } else if (op.equals("-")) {
                    res -= operand;
                } else if (op.equals("*")) {
                    res *= operand;
                }
            } else {
                op = s;
            }
        }
        pq.add(-res);
    }
}

