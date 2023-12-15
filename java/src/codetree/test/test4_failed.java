package 코드트리.진단테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class test4_failed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /*
        * 그러면 2의 n제곱 - 1 까지의 수를 이진수로 변환한 뒤, 각각의 숫자를 완탐해서 00이 있는 경우 패스
        **/
        TreeSet<String> treeSet = new TreeSet<>();
        int target = (int)(Math.pow(2, n));
        for (int i = 1; i < target; i++) {
            String binaryString = Integer.toBinaryString(i);
            if (binaryString.length() < n) {

            }

            if (isOkay(binaryString)) {
                treeSet.add(binaryString);
            }
        }
        for (int i = 0; i < treeSet.size(); i++) {
            System.out.println(treeSet.pollLast());
        }
    }

    public static boolean isOkay(String s) {
        for (int i = 0; i < s.length()-1; i++) {
            boolean equals = s.substring(i, i + 1).equals("00");
            if (equals) {
                return false;
            }
        }
        return true;
    }
}
