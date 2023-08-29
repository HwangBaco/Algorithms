package 코드트리.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/*
n 입력받기
loop n : 숫자 입력받기

1. loop n * 3 : 3개의 숫자 고르는 경우 완전탐색 a, b, c
2. 3개 숫자의 합 도출 (res)
3. _a = 0, _b = 0, _c = 0;
4. loop res.length : i < a.length보다 작을 경우, _a = a[i] / ...
5. _a + _b + _c > 10이면 isCarry = true;
6. if (!isCarry) : ans.add(res);
7. if (ans.length == 0) : print(-1);
   else : print(ans.stream().max().orElseThrows(() -> ...);
**/
public class Carry피하기2 {
    private static int[] arr;
    private static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        int res = 0;
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < n - 2; i++) {
            a = arr[i];
//            System.out.println("a = " + a);
            for (int j = i + 1; j < n - 1; j++) {
                b = arr[j];
//                System.out.println("b = " + b);
                for (int k = j + 1; k < n; k++) {
                    c = arr[k];
//                    System.out.println("c = " + c);
                    res = a + b + c;
//                    System.out.println("res = " + res);
                    op(res, a, b, c);
                }
            }
        }
        if (ans.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans.stream().mapToInt(i->i).max().orElseThrow(() -> new NoSuchElementException("")));
        }

    }

    private static void op(int res, int a, int b, int c) {
//        System.out.println("op start------------------------");
        boolean isCarry = false;
        String s = String.valueOf(res);
        int size = s.length();
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        String cStr = String.valueOf(c);
        int aCnt = aStr.length();
        int bCnt = bStr.length();
        int cCnt = cStr.length();
        for (int i = 0; i < size; i++) {
            int _a = 0, _b = 0, _c = 0;
            if (aCnt-- > 0) {
                _a = Integer.parseInt(aStr.substring(aCnt, aCnt + 1));
//                System.out.println("_a = " + _a);
            }
            if (bCnt-- > 0) {
                _b = Integer.parseInt(bStr.substring(bCnt, bCnt + 1));
//                System.out.println("_b = " + _b);
            }
            if (cCnt-- > 0) {
                _c = Integer.parseInt(cStr.substring(cCnt, cCnt + 1));
//                System.out.println("_c = " + _c);
            }
            if ((_a + _b + _c) >= 10) {
                isCarry = true;
//                System.out.println("isCarry = " + isCarry);
                break;
            }
        }
        if (!isCarry) {
            ans.add(res);
//            System.out.println("ans . add (res) = " + res);
            isCarry = false;
        }
    }
}
