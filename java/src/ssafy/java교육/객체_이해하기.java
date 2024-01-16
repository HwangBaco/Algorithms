package ssafy.java교육;

public class 객체_이해하기 {
    public static void main(String[] args) {
        String s1 = "이건 literal pool에 저장되는 문자열입니다.";
        String s2 = "이건 literal pool에 저장되는 문자열입니다.";
        String s3 = new String("이건 literal pool에 저장되는 문자열입니다.");

        System.out.println(s1==s2); // true
        System.out.println(s1==s3); // false
        s3 = s3.intern();
        System.out.println(s1==s3); // true
    }
}
