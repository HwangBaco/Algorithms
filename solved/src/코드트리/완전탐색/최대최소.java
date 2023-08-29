//package 코드트리.완전탐색;
//
//public class 최대최소 {
//    /*
//    Question.
//    5개의 숫자 [1, 5, 2, 6, 8]이 주어졌을 때
//    이 중 단 하나의 숫자만 두 배로 해서, 인접한 숫자간의 차이의 합이 최대가 되도록 해보세요.
//    **/
//
//    /*
//    TIP.
//    최댓값을 구해주는 경우에는 다음과 같이 maxVal에 INT_MIN 값을,
//    최솟값을 구해주는 경우에는 minVal에 INT_MAX를 초기값으로 넣어주는 과정이 필요합니다.
//    **/
//    public class Main {
//        public static final int INT_MIN = Integer.MIN_VALUE;
//        public static final int INT_MAX = Integer.MAX_VALUE;
//
////        public static int n = 5;
//        public static int[] arr = new int[]{-6, -5, -2, -10, -15};
//
//        public static void main(String[] args) {
//            int maxVal = INT_MIN;
//            for (int i = 0; i < n; i++)
//                if (arr[i] > maxVal)
//                    maxVal = arr[i];
//
//            int minVal = INT_MAX;
//            for (int i = 0; i < n; i++)
//                if (arr[i] < minVal)
//                    minVal = arr[i];
//
//            System.out.println(maxVal + " " + minVal);
//        }
//    }
//}
