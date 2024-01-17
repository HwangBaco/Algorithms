package 코드트리.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T0009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        br.close();
        Num[] sorted_arr = new Num[n];
        Num[] arr = new Num[n];
        for (int i = 0; i < n; i++) {
            sorted_arr[i] = new Num(Integer.parseInt(st.nextToken()));
            arr[i] = new Num(sorted_arr[i].num);
        }
        Arrays.sort(sorted_arr, (a, b) -> a.num - b.num);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i].num == sorted_arr[j].num && arr[j].isChecked == false) {
                    arr[j].isChecked = true;
                    System.out.print(j + 1 + " ");
                    break;
                }
            }
        }
    }

    public static class Num {
        private int num;
        private boolean isChecked;

        public Num(int num) {
            this.num = num;
            this.isChecked = false;
        }
    }
}
