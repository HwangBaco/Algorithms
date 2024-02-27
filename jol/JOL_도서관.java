package 알고리즘연습.jol;

import java.io.*;
import java.util.*;

public class JOL_도서관 {
    static final int START = 0;
    static final int END = 1;
    public static void main(String[] args) throws IOException {
        /*
        * 실행시간 : 286 ms
        *
        * 메모리 : 39.3 MB
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<int[]> li = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            li.add(new int[]{s, e});
        }

        Collections.sort(li, Comparator.comparingInt(o -> o[0]));

        int startMin = 1;
        int endMax = 1;
        int present = 0;
        int vacant = li.get(0)[START];
        for (int[] p : li) {
            if (endMax < p[START]) {
                startMin = p[START];
                vacant = Math.max(vacant, startMin - endMax);
                endMax = p[END];
            } else {
                endMax = Math.max(endMax, p[END]);
            }
            present = Math.max(present, endMax - startMin);
        }
        bw.write(present + " " + vacant);

        br.close();
        bw.flush();
        bw.close();
    }
}
