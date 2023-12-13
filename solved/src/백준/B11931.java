package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class B11931 {

    public static void main(String[] args) throws IOException {
        TreeSet<Integer> ts = new TreeSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            ts.add(num);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(ts.pollLast().toString()).append("\n");
        }
        System.out.println(sb);
    }
}
