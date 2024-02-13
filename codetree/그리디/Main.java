package 알고리즘연습.codetree.그리디;

import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<String> inputList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = br.readLine();
        }

        String ans = solution(arr);

        bw.write(ans);
        br.close();
        bw.flush();
        bw.close();
    }

    private static String solution(String[] arr) {
        Arrays.sort(arr, (s1, s2) -> {
            String ss1 = s1 + s2;
            String ss2 = s2 + s1;

            return ss2.compareTo(ss1);
        });

        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}