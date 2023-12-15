//package 백준.모의테스트4주차_KAUPC대비;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class B17828_문자열화폐 {
//    public static int n, x;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        x = Integer.parseInt(st.nextToken());
//        StringBuilder sb = new StringBuilder();
//        // A는 65 ~ 1이 A가 되려면 +64
//        if (!inRange()) {
//            System.out.println("!");
//        } else {
//            int last = x / 26;
////            for (int i = 0; i < last; i++) {
////                sb.append("Z");
////            }
//            sb.append("Z".repeat(last));
////            String s = String.copyValueOf(new char[]{(char) ((x % 26) + 64)});
//            int temp = (n - sb.length() - 1);
//            if (sb.length() < n) {
//                sb.insert(0, (char) ((x % 26) + 64 - temp));
//            }
//
////            for (int i = 0; i < temp; i++) {
////                sb.insert(0, "A");
////            }
//            sb.insert(0, "A".repeat(temp));
//            System.out.println(sb.toString());
//        }
//    }
//
//    public static boolean inRange() {
//        return x <= (n * 26) && x >= n;
//    }
//}
