package 코드트리.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class T0004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String t = st.nextToken();

        int idx = 0;

        List<String> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() >= t.length()) {
                String ss = s.substring(0, t.length());
                if (ss.equals(t)) {
                    li.add(s);
                }
            } else {
                continue;
            }
        }
        Collections.sort(li);
        System.out.println(li.get(k-1));
    }
}
