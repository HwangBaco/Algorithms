package 코드트리.시간단축기술.LR_테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 미래가_보이는_가위바위보 {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        int[] L_H = new int[n+1];
        int[] L_S = new int[n+1];
        int[] L_P = new int[n+1];
        int[] R_H = new int[n+1];
        int[] R_S = new int[n+1];
        int[] R_P = new int[n+1];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            arr[i] = s;
        }
        for (int i = 0; i < n; i++) {
            int hwin = 0;
            int swin = 0;
            int pwin = 0;
            if (arr[i].equals("H")) {
                pwin++;
            } else if (arr[i].equals("S")) {
                hwin++;
            } else {
                swin++;
            }
            L_H[i+1] = L_H[i] + hwin;
            L_P[i+1] = L_P[i] + pwin;
            L_S[i+1] = L_S[i] + swin;
            hwin = 0;
            swin = 0;
            pwin = 0;
            if (arr[n-i-1].equals("H")) {
                pwin++;
            } else if (arr[n-i-1].equals("S")) {
                hwin++;
            } else {
                swin++;
            }
            R_H[i+1] = R_H[i] + hwin;
            R_P[i+1] = R_P[i] + pwin;
            R_S[i+1] = R_S[i] + swin;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i < n; i++) {
            set.add(L_H[i] + R_S[n - i + 1]);
            set.add(L_H[i] + R_P[n - i + 1]);
            set.add(L_S[i] + R_H[n - i + 1]);
            set.add(L_S[i] + R_P[n - i + 1]);
            set.add(L_P[i] + R_S[n - i + 1]);
            set.add(L_P[i] + R_H[n - i + 1]);
        }
        System.out.println(set.last());
    }
}
