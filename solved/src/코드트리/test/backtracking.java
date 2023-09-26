package 코드트리.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class backtracking {
    private static int n;
    private static List<String> li = new ArrayList<>();
    private static List<String> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        long prev = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        go();
        ans.forEach(System.out::println);

        long after = System.currentTimeMillis();
        long diff = after - prev;
        System.out.println("diff = " + diff);
    }

    public static void go() {
        if (li.size() == n) {
            if (n >= 3) {
                for (int i = 2; i < n; i++) {
                    if (li.get(i - 2).equals(li.get(i - 1)) && li.get(i - 1).equals(li.get(i))) {
                        return;
                    }
                }
            }
            StringBuffer sb = new StringBuffer("");
            li.forEach(sb::append);
            String s = sb.toString();
            ans.add(s);
            return;
        }
        for (int i = 0; i < 2; i++) {
            li.add(String.valueOf(i));
            go();
            li.remove(li.size() - 1);
        }
    }
}

