package ssafy.java교육;

import java.io.IOException;

public class 배열 {
    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr); // [I@7ef20235
        System.out.println(arr.toString()); // [I@7ef20235

        String org = "HELLO";
        char[] charArray = org.toCharArray();
        System.out.println(charArray); // HELLO
        System.out.println(charArray.toString()); // [C@7ef20235
    }
}
