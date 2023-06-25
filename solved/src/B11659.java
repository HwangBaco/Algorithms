import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class B11659 /*백준 11659*/ {
    /*
    @pseudo code

    1. n, m 입력받기
    2. li 입력받기
    3. for i in range(m):
        i, j 입력받고
        구간합 반환하고

    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        // 리스트 생성
        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<Integer> accSumList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            li.add(Integer.parseInt(st.nextToken()));
        }
        accSumList.add(li.get(0));
        for (int i = 0; i < n-1; i++) {
            accSumList.add(accSumList.get(i) + li.get(i + 1));
        }
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if (i - 2 >= 0) {
                System.out.println(accSumList.get(j - 1) - accSumList.get(i - 2));
            } else {
                System.out.println(accSumList.get(j - 1));
            }
        }
        br.close();
    }
}

