package 알고리즘연습.codetree.기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CodeTree_코드트리오마카세 {
    /*
    * 틀림
    * */
    private static int L; // 초밥 벨트의 길이 (10억 이하)
    private static int Q; // 명령의 수
    private static final int CMD = 0;
    private static final int TIME = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); // 1e9
        Q = Integer.parseInt(st.nextToken()); // 1e6

        TreeSet<Person> ts = new TreeSet<>(Comparator.comparingInt(o -> -o.t)); // 내림차순
    }

    public static class Person {
        int x;
        int t;
        String name;

        public Person(int x, int t, String name) {
            this.x = x;
            this.t = t;
            this.name = name;
        }
    }
}
