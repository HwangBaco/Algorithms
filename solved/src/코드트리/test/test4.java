//package 코드트리.test;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class test4 {
//    private static int n;
//    private static List<Integer> li = new ArrayList<>();
//    private static int one;
//    private static String s = "";
//    private static int zero;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        go();
//
//    }
//    private static void go() {
//        if (/*li.size() == n*/ s.length() == n) {
//            if (isOk(s)) {
//               // 출력
//                for ()
////                for (Integer i : li) {
////                    System.out.print(i);
////                }
//                System.out.println();
//            }
//            return;
//        }
//        for (int i = 0; i < 2; i++) {
////            li.add(i);
//            s = s + String.valueOf(i);
//            if (i == 1) {
//                one++;
//            } else if (i == 0) {
//                zero++;
//            }
//            go();
////            li.remove(li.size() - 1);
//            s = s.substring(0, s.length() - 1);
//        }
//    }
//
//    private static boolean isOk(String s) {
//        int one = 0;
//        int zero = 0;
//        String[] split = s.split("");
//        for (String i : split) {
//            if (i.equals("1")) {
//                one++;
//            } else if (s.equals("0")) {
//                zero++;
//            }
//        }
//        if (one >= 2 && zero >= 2) {
//            return true;
//        }
//        return false;
//    }
//}
